DROP TABLE IF EXISTS `db_mno`.`tb_sim`;
CREATE TABLE `db_mno`.`tb_sim`
(
    `id`            BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `iccid`         VARCHAR(50) NOT NULL COMMENT '集成电路卡识别码',
    `imsi`          VARCHAR(50)          DEFAULT NULL COMMENT '国际移动用户识别号',
    `msisdn`        VARCHAR(20) NOT NULL COMMENT '手机号',
    `mno_code`      VARCHAR(50) NOT NULL COMMENT '运营商编码',
    `sim_state`     SMALLINT    NOT NULL COMMENT 'SIM卡状态：1-测试，2-库存，3-激活',
    `sms_ability`   TINYINT              DEFAULT 0 COMMENT '短信能力',
    `data_ability`  TINYINT              DEFAULT 0 COMMENT '数据能力',
    `voice_ability` TINYINT              DEFAULT 0 COMMENT '语音能力',
    `description`   VARCHAR(255)         DEFAULT NULL COMMENT '备注',
    `create_time`   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`     VARCHAR(64)          DEFAULT NULL COMMENT '创建者',
    `modify_time`   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `modify_by`     VARCHAR(64)          DEFAULT NULL COMMENT '修改者',
    `row_version`   INT                  DEFAULT 1 COMMENT '记录版本',
    `row_valid`     TINYINT              DEFAULT 1 COMMENT '记录是否有效',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`iccid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='SIM卡信息表';