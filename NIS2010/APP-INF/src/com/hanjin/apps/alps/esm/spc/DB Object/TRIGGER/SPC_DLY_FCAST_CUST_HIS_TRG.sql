CREATE OR REPLACE TRIGGER NISADM.SPC_DLY_FCAST_CUST_HIS_TRG
  after insert OR UPDATE on SPC_DLY_FCAST_CUST
for each row
/*
  1.Name       : SPC_DLY_FCAST_CUST_HIS_TRG
  2.Create Date: 2007-12-07
  3.Description:
      - 용도: Daily Forecast 변경 정보의 History를 저장한다
  4.Revision History
    2007-12-07 : 서관영 최초생성.
    2008-02-20 : 서관영 BKG QTY 추가
    2010-04-09 : CHOI.Y.S ALPS 이관하면서 POL_CD, POD_CD -> POL_YD_CD, POD_YD_CD 변경
    2010-07-08 : LEE.S.Y [프로젝트] Ticket ID : CHM-201004171 53ft 추가 관련 수정
    2013-02-05 : 김수정 [Ticket ID : CHM-201322502] 성수기 선복운영 프로젝트 - FCAST_SEQ PK 추가 및 20/40FT, S/C 추가
    2013-02-15 : 김수정 [Ticket ID : CHM-201322502] 성수기 선복운영 프로젝트 - Contract Forecast 항목 추가
    2014-02-06 : [CHM-201428383-01] RFA 추가
    2014-07-18:K.S.M   - [프로젝트] CHM-201431081 : USA_BKG_MOD_CD,DEST_LOC_CDD 추가
*/

DECLARE V_USER VARCHAR2(50); 
BEGIN

    V_USER := SYS_CONTEXT('USERENV', 'AUTHENTICATED_IDENTITY');
--    IF V_USER != 'SPCAPPL' THEN
    INSERT INTO SPC_DLY_FCAST_CUST_HIS
        (   
            RLANE_CD,
            DIR_CD,
            VSL_CD,
            SKD_VOY_NO,
            SKD_DIR_CD,
            IOC_TS_CD,
            SREP_USR_ID,
            CUST_CNT_CD,
            CUST_SEQ,
            FCAST_SEQ,
            POL_YD_CD,
            POD_YD_CD,
            FCAST_OFC_CD,
            FCAST_CUST_TP_CD,
            MODI_SEQ,
            IOC_CD,
            REP_TRD_CD,
            REP_SUB_TRD_CD,
            TRD_CD,
            SUB_TRD_CD,
            SC_NO,
            RFA_NO,
            SLS_RHQ_CD,
            SLS_AQ_CD,
            SLS_RGN_OFC_CD,
            SLS_OFC_CD,
            FCAST_TTL_QTY,
            FCAST_20FT_QTY,
            FCAST_40FT_QTY,
            FCAST_40FT_HC_QTY,
            FCAST_45FT_HC_QTY,
            FCAST_53FT_QTY,
            FCAST_RF_QTY,
            FCAST_TTL_WGT,
            CFM_TTL_QTY,
            CFM_40FT_HC_QTY,
            CFM_45FT_HC_QTY,
            CFM_53FT_QTY,
            CFM_RF_QTY,
            CFM_TTL_WGT,
            CTRL_LVL_CD,
            MODI_GDT,
            CFM_USR_ID,
            CFM_DT,
            CRE_USR_ID,
            CRE_DT,
            UPD_USR_ID,
            UPD_DT,
            CFM_FLG,
            USD_BKG_TTL_QTY,
            USD_BKG_20FT_QTY,
            USD_BKG_40FT_QTY,
            USD_BKG_40FT_HC_QTY,
            USD_BKG_45FT_HC_QTY,
            USD_BKG_53FT_QTY,
            USD_BKG_RF_QTY,
            USD_BKG_TTL_WGT,
            CTRT_FCAST_TTL_QTY, 
            CTRT_FCAST_20FT_QTY, 
            CTRT_FCAST_40FT_QTY, 
            CTRT_FCAST_40FT_HC_QTY, 
            CTRT_FCAST_45FT_HC_QTY, 
            CTRT_FCAST_53FT_QTY, 
            CTRT_FCAST_RF_QTY, 
            CTRT_FCAST_TTL_WGT,
            USA_BKG_MOD_CD,
            DEST_LOC_CD,
            FCAST_20FT_DRY_QTY,
            FCAST_40FT_DRY_QTY,
            FCAST_RD_QTY,
            CFM_20FT_DRY_QTY,
            CFM_40FT_DRY_QTY,
            CFM_RD_QTY,
            USD_BKG_20FT_DRY_QTY,
            USD_BKG_40FT_DRY_QTY,
            USD_BKG_RD_QTY
        )
    VALUES
        (  
            :new.RLANE_CD,
            :new.DIR_CD,
            :new.VSL_CD,
            :new.SKD_VOY_NO,
            :new.SKD_DIR_CD,
            :new.IOC_TS_CD,
            :new.SREP_USR_ID,
            :new.CUST_CNT_CD,
            :new.CUST_SEQ,
            :new.FCAST_SEQ,
            :new.POL_YD_CD,
            :new.POD_YD_CD,
            :new.FCAST_OFC_CD,
            :new.FCAST_CUST_TP_CD,
            (SELECT NVL(MAX(h.modi_seq), 0) + 1
               FROM SPC_DLY_FCAST_CUST_HIS h
              WHERE h.RLANE_CD    = :new.RLANE_CD
                AND h.DIR_CD      = :new.DIR_CD
                AND VSL_CD        = :new.VSL_CD
                AND SKD_VOY_NO    = :new.SKD_VOY_NO
                AND SKD_DIR_CD    = :new.SKD_DIR_CD
                AND IOC_TS_CD     = :new.IOC_TS_CD
                AND SREP_USR_ID   = :new.SREP_USR_ID
                AND CUST_CNT_CD   = :new.CUST_CNT_CD
                AND CUST_SEQ      = :new.CUST_SEQ
                AND FCAST_SEQ     = :new.FCAST_SEQ
                AND POL_YD_CD     = :new.POL_YD_CD
                AND POD_YD_CD     = :new.POD_YD_CD
                AND FCAST_OFC_CD  = :new.FCAST_OFC_CD
                AND FCAST_CUST_TP_CD = :new.FCAST_CUST_TP_CD
                AND USA_BKG_MOD_CD   = :new.USA_BKG_MOD_CD
                AND DEST_LOC_CD      = :new.DEST_LOC_CD
                ), 
            :new.IOC_CD,
            :new.REP_TRD_CD,
            :new.REP_SUB_TRD_CD,
            :new.TRD_CD,
            :new.SUB_TRD_CD,
            :new.SC_NO,
            :new.RFA_NO,
            :new.SLS_RHQ_CD,
            :new.SLS_AQ_CD,
            :new.SLS_RGN_OFC_CD,
            :new.SLS_OFC_CD,
            :new.FCAST_TTL_QTY,
            :new.FCAST_20FT_QTY,
            :new.FCAST_40FT_QTY,
            :new.FCAST_40FT_HC_QTY,
            :new.FCAST_45FT_HC_QTY,
            :new.FCAST_53FT_QTY,
            :new.FCAST_RF_QTY,
            :new.FCAST_TTL_WGT,
            :new.CFM_TTL_QTY,
            :new.CFM_40FT_HC_QTY,
            :new.CFM_45FT_HC_QTY,
            :new.CFM_53FT_QTY,
            :new.CFM_RF_QTY,
            :new.CFM_TTL_WGT,
            :new.CTRL_LVL_CD,
            :new.MODI_GDT,
            :new.CFM_USR_ID,
            :new.CFM_DT,
            :new.CRE_USR_ID,
            :new.CRE_DT,
            :new.UPD_USR_ID,
            :new.UPD_DT,
            DECODE(:new.CFM_DT,:new.UPD_DT,'Y','N'),
            :new.USD_BKG_TTL_QTY,
            :new.USD_BKG_20FT_QTY,
            :new.USD_BKG_40FT_QTY,
            :new.USD_BKG_40FT_HC_QTY,
            :new.USD_BKG_45FT_HC_QTY,
            :new.USD_BKG_53FT_QTY,
            :new.USD_BKG_RF_QTY,
            :new.USD_BKG_TTL_WGT,
            :new.CTRT_FCAST_TTL_QTY, 
            :new.CTRT_FCAST_20FT_QTY, 
            :new.CTRT_FCAST_40FT_QTY, 
            :new.CTRT_FCAST_40FT_HC_QTY, 
            :new.CTRT_FCAST_45FT_HC_QTY, 
            :new.CTRT_FCAST_53FT_QTY, 
            :new.CTRT_FCAST_RF_QTY, 
            :new.CTRT_FCAST_TTL_WGT,
            :new.USA_BKG_MOD_CD,
            :new.DEST_LOC_CD,
            :new.FCAST_20FT_DRY_QTY,
            :new.FCAST_40FT_DRY_QTY,
            :new.FCAST_RD_QTY,
            :new.CFM_20FT_DRY_QTY,
            :new.CFM_40FT_DRY_QTY,
            :new.CFM_RD_QTY,
            :new.USD_BKG_20FT_DRY_QTY,
            :new.USD_BKG_40FT_DRY_QTY,
            :new.USD_BKG_RD_QTY
         );
--     END IF;         
END SPC_DLY_FCAST_CUST_HIS_TRG;