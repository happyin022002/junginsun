CREATE OR REPLACE PROCEDURE OPUSADM.TRS_CHG_MGT_SO_UPD_PRC
/*******************************************************************************
    1. Object Name      : TRS_CHG_MGT_SO_UPD_PRC
    2. Version          : 1.0
    3. Create Date      : 2016.3.04
    4. Sub System       : TRS
    5. Author           :
    6. Description      : Booking S/O Update -> Shipment C/M
    7. Revision History :
  *******************************************************************************/
(
 IN_NEW_BKG_NO IN VARCHAR2 DEFAULT NULL
) 
AUTHID CURRENT_USER 
IS
BEGIN
  FOR CHG_SO IN (SELECT SO.TRSP_SO_OFC_CTY_CD,
                        SO.TRSP_SO_SEQ,
                        SO.BKG_NO             SO_BKG_NO,
                        CN.BKG_NO             CN_BKG_NO,
                        SO.EQ_NO,
                        SO.EQ_TPSZ_CD,
                        SO.LOCL_UPD_DT,
                        SO.UPD_DT,
                        SO.UPD_USR_ID
                   FROM TRS_TRSP_SVC_ORD SO, TRS_TRSP_SVC_ORD_CNG CN
                  WHERE SO.TRSP_SO_OFC_CTY_CD = CN.TRSP_SO_OFC_CTY_CD
                    AND SO.TRSP_SO_SEQ = CN.TRSP_SO_SEQ
                    AND SO.BKG_NO <> CN.BKG_NO
                    AND SO.BKG_NO = NVL(IN_NEW_BKG_NO, SO.BKG_NO)
                    AND SO.DELT_FLG <> 'Y') LOOP
    BEGIN
      TRS_CHG_MGT_SO_CREATE_PRC(CHG_SO.TRSP_SO_OFC_CTY_CD, CHG_SO.TRSP_SO_SEQ, TRUE);
    END;
  END LOOP;
END TRS_CHG_MGT_SO_UPD_PRC;
/