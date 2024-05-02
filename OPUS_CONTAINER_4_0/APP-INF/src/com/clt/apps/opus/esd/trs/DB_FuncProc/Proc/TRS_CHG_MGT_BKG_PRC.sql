CREATE OR REPLACE PROCEDURE OPUSADM.TRS_CHG_MGT_BKG_PRC
 /*******************************************************************************
   1. Object Name      : TRS_CHG_MGT_BKG_PRC
   2. Version          : 1.0
   3. Create Date      : 2015.02.25
   4. Sub System       : TRS
   5. Author           : SangGeun Kim
   6. Description      : When you update booking information, this applicable procedure works as the below statement.
   7. Revision History : 2015.02.25 SangGeun Kim 1.0 Created
 *******************************************************************************/
(
    in_cate_sep_cd  IN VARCHAR2,
    in_chage_flg    IN VARCHAR2,
    in_bkg_no       IN VARCHAR2, --Primary Key
    in_bnd_cd       IN VARCHAR2, --Primary Key
    in_rtn_pre_flg  IN VARCHAR2, --Primary Key
    in_tro_seq      IN NUMBER,   --Primary Key
    in_tro_sub_seq  IN NUMBER,   --Primary Key
    in_spcl_seq     IN NUMBER,   --Primary Key
    in_vsl_seq      IN NUMBER,   --Primary Key
    in_delt_flg     IN VARCHAR2,
    in_usr_id       IN VARCHAR2,
    in_usr_off_cd   IN VARCHAR2
)

AUTHID CURRENT_USER
  IS
    v_bkg_no                  TRS_TRSP_SVC_ORD.BKG_NO%TYPE            ; --V(13)
    v_eq_no                   TRS_TRSP_SVC_ORD.EQ_NO%TYPE             ; --V(15)
    v_eq_tpsz_cd              TRS_TRSP_SVC_ORD.EQ_TPSZ_CD%TYPE        ; --V(4)
    v_prmry_col_nm            TRS_TRSP_BKG_CNG.PRMRY_COL_NM%TYPE      ; --V(100)
    v_prmry_col_val_rmk       TRS_TRSP_BKG_CNG.PRMRY_COL_VAL_RMK%TYPE ; --V(500)
    v_tbl_nm                  TRS_TRSP_BKG_CNG.TBL_NM%TYPE            ; --V(100)
    v_col_nm                  TRS_TRSP_BKG_CNG.COL_NM%TYPE            ; --V(500)
    v_col_n1st_rmk            TRS_TRSP_BKG_CNG.COL_N1ST_RMK%TYPE      ; --V(4000)
    v_col_n2nd_rmk            TRS_TRSP_BKG_CNG.COL_N2ND_RMK%TYPE      ; --V(4000)

    v_sc_cate      VARCHAR2(2) := 'SC'; --Special Cargo
    v_dg_cate_sub  VARCHAR2(2) := 'DG'; --Dangerous
    v_rf_cate_sub  VARCHAR2(2) := 'RF'; --Reefer
    v_aw_cate_sub  VARCHAR2(2) := 'AW'; --Awkward

    v_cn_cate      VARCHAR2(2) := 'CN'; --Cargo Nature(Booking Main)
    v_cn_cate_sub  VARCHAR2(2) := 'CN'; --Cargo Nature(Booking Main)

    v_vv_cate      VARCHAR2(2) := 'VV'; --Vessel/Voyage
    v_sv_cate_sub  VARCHAR2(2) := 'SV'; --Pre VVD
    v_tv_cate_sub  VARCHAR2(2) := 'TV'; --T/VVD

    v_at_cate      VARCHAR2(2) := 'AT'; --Appointment(TRO)
    v_cr_cate      VARCHAR2(2) := 'CR'; --Cargo Release
    v_us_cate_sub  VARCHAR2(2) := 'US'; --USA
    v_eu_cate_sub  VARCHAR2(2) := 'EU'; --EUR

    v_cu_cate      VARCHAR2(2);        --Cut Off Category
    v_ff_cate_sub  VARCHAR2(2);        --Cut Off SubCategory
    p_clz_tp_cd    VARCHAR2(1);        --Cut Off CLZ_TP_CD

    v_div_cd       VARCHAR2(3) := '@#@';

    v_local_date   DATE;
    om_query       VARCHAR2(30000);

    v_cate_sub     VARCHAR2(2) := '';

    vcp_cnt        NUMBER;
    v_spec_seq     NUMBER;
    vcp_trsp_cng_sub_seq NUMBER;

    v_cng_cate_cd VARCHAR2(2) := '';
    v_cng_cate_sub_cd VARCHAR2(2) := '';
    v_trsp_cng_sub_seq NUMBER(4) := 1;
    v_so_cnt NUMBER := 0;

    OTHERS_EXC EXCEPTION;
    CURSOR BKG_SCDG IS
        SELECT
            BKG_NO, DCGO_SEQ, CNTR_NO, CNTR_TPSZ_CD
            , 'BKG_NO,DCGO_SEQ', BKG_NO||v_div_cd||DCGO_SEQ
            , 'BKG_DG_CGO', 'IMDG_UN_NO,IMDG_UN_NO_SEQ,IMDG_CLSS_CD,GRS_WGT,NET_WGT,PRP_SHP_NM,FLSH_PNT_CDO_TEMP,IMDG_PCK_GRP_CD,PSA_NO,MRN_POLUT_FLG,EMER_CNTC_PHN_NO_CTNT,EMER_CNTC_PSON_NM,HZD_DESC'
            , IMDG_UN_NO||v_div_cd||IMDG_UN_NO_SEQ||v_div_cd||IMDG_CLSS_CD||v_div_cd||GRS_WGT||v_div_cd||NET_WGT||v_div_cd
              ||PRP_SHP_NM||v_div_cd||FLSH_PNT_CDO_TEMP||v_div_cd||IMDG_PCK_GRP_CD||v_div_cd||PSA_NO||v_div_cd||MRN_POLUT_FLG||v_div_cd
              ||EMER_CNTC_PHN_NO_CTNT||v_div_cd||EMER_CNTC_PSON_NM
            , HZD_DESC
        FROM BKG_DG_CGO
        WHERE BKG_NO     = in_bkg_no
            AND DCGO_SEQ = in_spcl_seq;

    CURSOR BKG_SCRF IS
        SELECT
            BKG_NO, RC_SEQ, CNTR_NO, CNTR_TPSZ_CD
            , 'BKG_NO,RC_SEQ', BKG_NO||v_div_cd||RC_SEQ
            , 'BKG_RF_CGO', 'CDO_TEMP,FDO_TEMP,VENT_RTO'
            , CDO_TEMP||v_div_cd||FDO_TEMP||v_div_cd||VENT_RTO
            , NULL
        FROM BKG_RF_CGO
        WHERE BKG_NO   = in_bkg_no
            AND RC_SEQ = in_spcl_seq;

    CURSOR BKG_SCAW IS
        SELECT
            BKG_NO, AWK_CGO_SEQ, CNTR_NO, CNTR_TPSZ_CD
            , 'BKG_NO,AWK_CGO_SEQ', BKG_NO||v_div_cd||AWK_CGO_SEQ
            , 'BKG_AWK_CGO', 'TTL_DIM_LEN,TTL_DIM_WDT,TTL_DIM_HGT'
            , TTL_DIM_LEN||v_div_cd||TTL_DIM_WDT||v_div_cd||TTL_DIM_HGT
            , NULL
        FROM BKG_AWK_CGO
        WHERE BKG_NO        = in_bkg_no
            AND AWK_CGO_SEQ = in_spcl_seq;

    CURSOR BKG_ATAU IS
        SELECT
            B.BKG_NO, TO_NUMBER(B.TRO_SEQ||B.TRO_SUB_SEQ), B.CNTR_NO, B.CNTR_TPSZ_CD
            , 'BKG_NO,IO_BND_CD,RTN_TRO_FLG,TRO_SEQ,TRO_SUB_SEQ'
            , B.BKG_NO||v_div_cd||B.IO_BND_CD||v_div_cd||B.RTN_TRO_FLG||v_div_cd||B.TRO_SEQ||v_div_cd||B.TRO_SUB_SEQ
            , 'BKG_TRO,BKG_TRO_DTL', 'ZN_CD,DOR_PST_NO,ACT_SHPR_ADDR,DOR_ARR_DT,DIFF_RMK'
            , A.ZN_CD||v_div_cd||A.DOR_PST_NO||v_div_cd||A.ACT_SHPR_ADDR||v_div_cd||TO_CHAR(B.DOR_ARR_DT, 'YYYYMMDDHH24MISS')
            , A.DIFF_RMK
        FROM BKG_TRO A, BKG_TRO_DTL B
        WHERE A.BKG_NO        = B.BKG_NO
            AND A.IO_BND_CD   = B.IO_BND_CD
            AND A.RTN_TRO_FLG = B.RTN_TRO_FLG
            AND A.TRO_SEQ     = B.TRO_SEQ
            AND A.BKG_NO      = in_bkg_no
            AND A.IO_BND_CD   = in_bnd_cd
            AND A.RTN_TRO_FLG = in_rtn_pre_flg
            AND A.TRO_SEQ     = in_tro_seq
            AND B.TRO_SUB_SEQ = in_tro_sub_seq;

    CURSOR BKG_ATEU IS
        SELECT
            B.BKG_NO, TO_NUMBER(B.TRO_SEQ||B.TRO_SUB_SEQ), A.CNTR_NO, A.CNTR_TPSZ_CD
            , 'BKG_NO,IO_BND_CD,TRO_SEQ,TRO_SUB_SEQ', B.BKG_NO||v_div_cd||B.IO_BND_CD||v_div_cd||B.TRO_SEQ||v_div_cd||B.TRO_SUB_SEQ
            , 'BKG_EUR_TRO,BKG_EUR_TRO_DTL', 'DOR_ADDR,LOD_REF_NO,DOR_ZIP_ID,CNTC_PSON_NM,CNTC_PHN_NO,CNTC_EML,ARR_DT,SPCL_INSTR_RMK'
            , B.DOR_ADDR||v_div_cd||B.LOD_REF_NO||v_div_cd||B.DOR_ZIP_ID||v_div_cd||B.CNTC_PSON_NM||v_div_cd
              ||B.CNTC_PHN_NO||v_div_cd||B.CNTC_EML||v_div_cd||TO_CHAR(B.ARR_DT, 'YYYYMMDDHH24MISS')
            , A.SPCL_INSTR_RMK
        FROM BKG_EUR_TRO A, BKG_EUR_TRO_DTL B
        WHERE A.BKG_NO        = B.BKG_NO
            AND A.IO_BND_CD   = B.IO_BND_CD
            AND A.TRO_SEQ     = B.TRO_SEQ
            AND A.BKG_NO      = in_bkg_no
            AND A.IO_BND_CD   = in_bnd_cd
            AND A.TRO_SEQ     = in_tro_seq
            AND B.TRO_SUB_SEQ = in_tro_sub_seq;

    CURSOR BKG_CRUS IS
        SELECT
            BL_NO, 1, NULL, NULL
            , 'BL_NO', BL_NO
            , 'BKG_CGO_RLSE', 'FRT_CLT_FLG,OBL_RDEM_FLG,CSTMS_CLR_CD'
            , FRT_CLT_FLG||v_div_cd||OBL_RDEM_FLG||v_div_cd||CSTMS_CLR_CD
            , NULL
        FROM BKG_CGO_RLSE
        WHERE BL_NO = in_bkg_no;

    CURSOR BKG_VVDTS IS
        SELECT
            BKG_NO, 1, NULL, NULL
            , 'BKG_NO,VSL_PRE_PST_CD,VSL_SEQ', BKG_NO||v_div_cd||VSL_PRE_PST_CD||v_div_cd||VSL_SEQ
            , 'BKG_VVD', 'PRE_VSL_CD,PRE_SKD_VOY_NO,PRE_SKD_DIR_CD,PRE_SLAN_CD'
            , VSL_CD||v_div_cd||SKD_VOY_NO||v_div_cd||SKD_DIR_CD||v_div_cd||SLAN_CD
            , NULL
        FROM BKG_VVD
        WHERE BKG_NO           = in_bkg_no
            AND VSL_PRE_PST_CD = in_rtn_pre_flg
            AND VSL_SEQ        = in_vsl_seq;

    CURSOR BKG_CNCN IS
        SELECT X.BKG_NO ,1 ,NULL ,NULL
              ,'BKG_NO' ,X.BKG_NO
              ,'BKG_BOOKING' ,'DCGO_FLG_BB_CGO_FLG_AWK_CGO_FLG_RC_FLG_RD_CGO_FLG'
              ,CASE
                 WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) = 'Y' AND SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 2) + 1, INSTR(X.BKG_SPE, '^', 1, 3) - INSTR(X.BKG_SPE, '^', 1, 2) - 1) = 'Y' THEN 'AD'
                 WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) = 'Y' AND SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 3) + 1, INSTR(X.BKG_SPE, '^', 1, 4) - INSTR(X.BKG_SPE, '^', 1, 3) - 1) = 'Y' THEN 'RD'
                 WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) = 'Y'
                      AND SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 2) + 1, INSTR(X.BKG_SPE, '^', 1, 3) - INSTR(X.BKG_SPE, '^', 1, 2) - 1) != 'Y'
                      AND SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 3) + 1, INSTR(X.BKG_SPE, '^', 1, 4) - INSTR(X.BKG_SPE, '^', 1, 3) - 1) != 'Y'
                      THEN 'DG'
                 WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) != 'Y' AND SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 2) + 1, INSTR(X.BKG_SPE, '^', 1, 3) - INSTR(X.BKG_SPE, '^', 1, 2) - 1) = 'Y' THEN 'AK'
                 WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) != 'Y' AND SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 3) + 1, INSTR(X.BKG_SPE, '^', 1, 4) - INSTR(X.BKG_SPE, '^', 1, 3) - 1) = 'Y' THEN 'RF'
                 WHEN SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 1) + 1, INSTR(X.BKG_SPE, '^', 1, 2) - INSTR(X.BKG_SPE, '^', 1, 1) - 1) = 'Y' THEN 'BB'
                 ELSE 'GP'
               END AS SPCL_CGO_CNTR_TP_CD
              ,NULL
          FROM (SELECT BKG_NO
                      ,NVL(BKG.DCGO_FLG, ' ') || '^' || NVL(BKG.BB_CGO_FLG, ' ') || '^' || NVL(BKG.AWK_CGO_FLG, ' ') || '^' || NVL(BKG.RC_FLG, ' ') || '^' || NVL(BKG.RD_CGO_FLG, ' ') || '^' AS BKG_SPE
                  FROM BKG_BOOKING BKG
                 WHERE BKG.BKG_NO = in_bkg_no) X;

    CURSOR BKG_CUFF (in_clz_tp_cd VARCHAR2) IS
        SELECT
            BKG_NO, 1, NULL, NULL
            , 'BKG_NO, CLZ_TP_CD', BKG_NO ||v_div_cd|| CLZ_TP_CD
            , 'BKG_CLZ_TM', 'MNL_SET_DT_SYS_SET_DT'
            ,  NVL(TO_CHAR(MNL_SET_DT, 'YYYY-MM-DD HH24:MI:SS'), TO_CHAR(SYS_SET_DT, 'YYYY-MM-DD HH24:MI:SS'))
            , NULL
        FROM BKG_CLZ_TM
        WHERE BKG_NO = in_bkg_no
        AND   CLZ_TP_CD = in_clz_tp_cd;

BEGIN
  DBMS_OUTPUT.disable;
  om_query := 'INSERT INTO TRS_TRSP_BKG_CNG_HIS (
                  BKG_NO, CNG_CATE_CD, CNG_CATE_SUB_CD, TRSP_CNG_SUB_SEQ, TRSP_CNG_SUB_HIS_SEQ
                  , CNTR_NO, CNTR_TPSZ_CD, TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, CNG_IND_FLG
                  , PRMRY_COL_NM, PRMRY_COL_VAL_RMK, TBL_NM, COL_NM, COL_N1ST_RMK, COL_N2ND_RMK
                  , DELT_FLG, LOCL_CRE_DT, LOCL_UPD_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT
              )
              SELECT
                  BKG_NO, CNG_CATE_CD, CNG_CATE_SUB_CD, TRSP_CNG_SUB_SEQ,
                  (SELECT NVL(MAX(B.TRSP_CNG_SUB_HIS_SEQ)+1, 1) FROM TRS_TRSP_BKG_CNG_HIS B
                   WHERE B.BKG_NO = O.BKG_NO AND B.CNG_CATE_CD = O.CNG_CATE_CD AND B.CNG_CATE_SUB_CD = O.CNG_CATE_SUB_CD
                      AND B.TRSP_CNG_SUB_SEQ = O.TRSP_CNG_SUB_SEQ) AS  TRSP_CNG_SUB_HIS_SEQ
                  , CNTR_NO, CNTR_TPSZ_CD, TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, CNG_IND_FLG
                  , PRMRY_COL_NM, PRMRY_COL_VAL_RMK, TBL_NM, COL_NM, COL_N1ST_RMK, COL_N2ND_RMK
                  , DELT_FLG, LOCL_CRE_DT, LOCL_UPD_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT
              FROM TRS_TRSP_BKG_CNG O';

  IF in_chage_flg = 'N' THEN
     DBMS_OUTPUT.PUT_LINE('Not Changed.');
     RAISE OTHERS_EXC;
  END IF;

  SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(in_usr_off_cd) INTO v_local_date FROM DUAL;
  SELECT COUNT(*) INTO v_so_cnt FROM TRS_TRSP_SVC_ORD SO WHERE SO.BKG_NO = in_bkg_no AND SO.DELT_FLG = 'N';

  IF in_cate_sep_cd IN ('ATAI', 'ATUS', 'ATEU') THEN
    SELECT COUNT(*) INTO v_so_cnt
      FROM TRS_TRSP_SVC_ORD SO
     WHERE SO.BKG_NO = in_bkg_no
       AND SO.TRO_SEQ = in_tro_seq
       AND SO.TRO_SUB_SEQ = in_tro_sub_seq
       AND SO.DELT_FLG = 'N';
  END IF;

  --TRS_TRSP_SVC_ORD_CNG Creation.
  IF v_so_cnt = 0 THEN
    DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND!');
    RAISE OTHERS_EXC;
  ELSE
    BEGIN
      FOR TMP_SO IN (SELECT TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, BKG_NO, EQ_NO, EQ_TPSZ_CD, LOCL_CRE_DT, LOCL_UPD_DT, CRE_USR_ID,CRE_DT, UPD_USR_ID,UPD_DT  FROM TRS_TRSP_SVC_ORD WHERE BKG_NO = in_bkg_no AND DELT_FLG = 'N') LOOP
        MERGE INTO TRS_TRSP_SVC_ORD_CNG C
        USING DUAL
        ON (C.TRSP_SO_OFC_CTY_CD = TMP_SO.TRSP_SO_OFC_CTY_CD AND C.TRSP_SO_SEQ = TMP_SO.TRSP_SO_SEQ AND C.TRSP_SO_SUB_SEQ = 1)
        WHEN NOT MATCHED THEN
          INSERT (TRSP_SO_OFC_CTY_CD,TRSP_SO_SEQ,TRSP_SO_SUB_SEQ,BKG_NO,EQ_NO,CNTR_TPSZ_CD,CNG_IND_FLG,DELT_FLG,LOCL_CRE_DT,LOCL_UPD_DT,CRE_USR_ID, CRE_DT,UPD_USR_ID,UPD_DT)
          VALUES (TMP_SO.TRSP_SO_OFC_CTY_CD,TMP_SO.TRSP_SO_SEQ,1,TMP_SO.BKG_NO,TMP_SO.EQ_NO,TMP_SO.EQ_TPSZ_CD,'N','N',v_local_date,v_local_date,'BKGUSER',sysdate,'BKGUSER',sysdate)
        WHEN MATCHED THEN
          UPDATE
            SET EQ_NO = TMP_SO.EQ_NO
               ,CNTR_TPSZ_CD = TMP_SO.EQ_TPSZ_CD
               ,LOCL_UPD_DT = v_local_date
               ,UPD_USR_ID  = in_usr_id
               ,UPD_DT    = sysdate;
      END LOOP;
    END;
  END IF;
/*
 * BKG_DG_CGO
 * - Category : SC(Special Cargo) / Sub-Category : DG(Dangerous)
 */
    BEGIN
        IF in_cate_sep_cd = 'SCDG' THEN
            OPEN BKG_SCDG;
            LOOP
                FETCH BKG_SCDG INTO v_bkg_no, v_spec_seq, v_eq_no, v_eq_tpsz_cd, v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm, v_col_n1st_rmk, v_col_n2nd_rmk;
                IF BKG_SCDG%NOTFOUND THEN
                    IF v_bkg_no IS NULL THEN
                        UPDATE TRS_TRSP_BKG_CNG SET
                              DELT_FLG = 'Y'
                            , COL_N1ST_RMK = REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(COL_N1ST_RMK, '\^', '#####'), v_div_cd, '^'), '[^^]', ''), '\^',  v_div_cd)
                            , COL_N2ND_RMK = ''
                            , LOCL_UPD_DT  = v_local_date
                            , UPD_USR_ID   = in_usr_id
                            , UPD_DT       = SYSDATE
                        WHERE BKG_NO             = in_bkg_no
                            AND CNG_CATE_CD      = v_sc_cate
                            AND CNG_CATE_SUB_CD  = v_dg_cate_sub
                            AND TRSP_CNG_SUB_SEQ = in_spcl_seq;

                        v_cng_cate_cd := v_sc_cate;
                        v_cng_cate_sub_cd := v_dg_cate_sub;
                        v_trsp_cng_sub_seq := in_spcl_seq;

                        EXECUTE IMMEDIATE om_query
                        || ' WHERE BKG_NO            = '''|| in_bkg_no      ||''''
                        || '    AND CNG_CATE_CD      = '''|| v_sc_cate      ||''''
                        || '    AND CNG_CATE_SUB_CD  = '''|| v_dg_cate_sub  ||''''
                        || '    AND TRSP_CNG_SUB_SEQ =   '|| in_spcl_seq;
                     END IF;
                     RAISE OTHERS_EXC;
                END IF;

                SELECT COUNT(*) INTO vcp_cnt FROM TRS_TRSP_BKG_CNG
                    WHERE BKG_NO             = in_bkg_no
                        AND CNG_CATE_CD      = v_sc_cate
                        AND CNG_CATE_SUB_CD  = v_dg_cate_sub
                        AND TRSP_CNG_SUB_SEQ = in_spcl_seq;
                IF vcp_cnt > 0 THEN
                    UPDATE TRS_TRSP_BKG_CNG SET
                          CNG_IND_FLG        = DECODE(CNG_IND_FLG, 'Y', 'Y', DECODE(COL_N1ST_RMK||COL_N2ND_RMK, v_col_n1st_rmk||v_col_n2nd_rmk, 'N', 'Y'))
                        , COL_N1ST_RMK       = v_col_n1st_rmk
                        , COL_N2ND_RMK       = v_col_n2nd_rmk
                        , DELT_FLG           = 'N'
                        , LOCL_UPD_DT        = v_local_date
                        , UPD_USR_ID         = in_usr_id
                        , UPD_DT             = SYSDATE
                    WHERE BKG_NO             = v_bkg_no
                        AND CNG_CATE_CD      = v_sc_cate
                        AND CNG_CATE_SUB_CD  = v_dg_cate_sub
                        AND TRSP_CNG_SUB_SEQ = v_spec_seq;
                ELSE
                    INSERT INTO TRS_TRSP_BKG_CNG (
                        BKG_NO, CNG_CATE_CD, CNG_CATE_SUB_CD, TRSP_CNG_SUB_SEQ, CNTR_NO, CNTR_TPSZ_CD
                        , CNG_IND_FLG, PRMRY_COL_NM, PRMRY_COL_VAL_RMK, TBL_NM, COL_NM, COL_N1ST_RMK, COL_N2ND_RMK
                        , DELT_FLG, LOCL_CRE_DT, LOCL_UPD_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT
                    ) VALUES (
                        in_bkg_no, v_sc_cate, v_dg_cate_sub, v_spec_seq, v_eq_no, v_eq_tpsz_cd
                        , 'Y', v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm
                        , v_col_n1st_rmk, v_col_n2nd_rmk, 'N', v_local_date, v_local_date, in_usr_id, SYSDATE, in_usr_id, SYSDATE
                    );
                END IF;
                v_cng_cate_cd := v_sc_cate;
                v_cng_cate_sub_cd := v_dg_cate_sub;
                v_trsp_cng_sub_seq := v_spec_seq;

                EXECUTE IMMEDIATE om_query
                || ' WHERE BKG_NO            = '''|| in_bkg_no      ||''''
                || '    AND CNG_CATE_CD      = '''|| v_sc_cate      ||''''
                || '    AND CNG_CATE_SUB_CD  = '''|| v_dg_cate_sub  ||''''
                || '    AND TRSP_CNG_SUB_SEQ =   '|| v_spec_seq;

            END LOOP;
            CLOSE BKG_SCDG;
        END IF;
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND');
    WHEN OTHERS_EXC THEN
        DBMS_OUTPUT.PUT_LINE('OTHERS_EXC');
    END;
--BKG_DG_CGO


/*
 * BKG_RF_CGO
 * - Category : SC(Special Cargo) / Sub-Category : RF(Reefer)
 */
    BEGIN
        IF in_cate_sep_cd = 'SCRF' THEN
            OPEN BKG_SCRF;
            LOOP
                FETCH BKG_SCRF INTO v_bkg_no, v_spec_seq, v_eq_no, v_eq_tpsz_cd, v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm, v_col_n1st_rmk, v_col_n2nd_rmk;
                IF BKG_SCRF%NOTFOUND THEN
                    IF v_bkg_no IS NULL THEN
                        UPDATE TRS_TRSP_BKG_CNG SET
                              DELT_FLG = 'Y'
                            , COL_N1ST_RMK = REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(COL_N1ST_RMK, '\^', '#####'), v_div_cd, '^'), '[^^]', ''), '\^',  v_div_cd)
                            , COL_N2ND_RMK = ''
                            , LOCL_UPD_DT  = v_local_date
                            , UPD_USR_ID   = in_usr_id
                            , UPD_DT       = SYSDATE
                        WHERE BKG_NO             = in_bkg_no
                            AND CNG_CATE_CD      = v_sc_cate
                            AND CNG_CATE_SUB_CD  = v_rf_cate_sub
                            AND TRSP_CNG_SUB_SEQ = in_spcl_seq;

                        v_cng_cate_cd := v_sc_cate;
                        v_cng_cate_sub_cd := v_rf_cate_sub;
                        v_trsp_cng_sub_seq := in_spcl_seq;

                        EXECUTE IMMEDIATE om_query
                        || ' WHERE BKG_NO            = '''|| in_bkg_no     ||''''
                        || '    AND CNG_CATE_CD      = '''|| v_sc_cate     ||''''
                        || '    AND CNG_CATE_SUB_CD  = '''|| v_rf_cate_sub ||''''
                        || '    AND TRSP_CNG_SUB_SEQ =   '|| in_spcl_seq;

                    END IF;
                    RAISE OTHERS_EXC;
                END IF;

                SELECT COUNT(*) INTO vcp_cnt FROM TRS_TRSP_BKG_CNG
                WHERE BKG_NO             = in_bkg_no
                    AND CNG_CATE_CD      = v_sc_cate
                    AND CNG_CATE_SUB_CD  = v_rf_cate_sub
                    AND TRSP_CNG_SUB_SEQ = in_spcl_seq;

                IF vcp_cnt > 0 THEN
                    UPDATE TRS_TRSP_BKG_CNG SET
                          CNG_IND_FLG        = DECODE(CNG_IND_FLG, 'Y', 'Y', DECODE(COL_N1ST_RMK||COL_N2ND_RMK, v_col_n1st_rmk||v_col_n2nd_rmk, 'N', 'Y'))
                        , COL_N1ST_RMK       = v_col_n1st_rmk
                        , COL_N2ND_RMK       = v_col_n2nd_rmk
                        , DELT_FLG           = 'N'
                        , LOCL_UPD_DT        = v_local_date
                        , UPD_USR_ID         = in_usr_id
                        , UPD_DT             = SYSDATE
                    WHERE BKG_NO             = v_bkg_no
                        AND CNG_CATE_CD      = v_sc_cate
                        AND CNG_CATE_SUB_CD  = v_rf_cate_sub
                        AND TRSP_CNG_SUB_SEQ = v_spec_seq;
                ELSE
                    INSERT INTO TRS_TRSP_BKG_CNG (
                        BKG_NO, CNG_CATE_CD, CNG_CATE_SUB_CD, TRSP_CNG_SUB_SEQ, CNTR_NO, CNTR_TPSZ_CD
                        , CNG_IND_FLG, PRMRY_COL_NM, PRMRY_COL_VAL_RMK, TBL_NM, COL_NM, COL_N1ST_RMK, COL_N2ND_RMK
                        , DELT_FLG, LOCL_CRE_DT, LOCL_UPD_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT
                    ) VALUES (
                        in_bkg_no, v_sc_cate, v_rf_cate_sub, v_spec_seq, v_eq_no, v_eq_tpsz_cd
                        , 'Y', v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm
                        , v_col_n1st_rmk, v_col_n2nd_rmk, 'N', v_local_date, v_local_date, in_usr_id, SYSDATE, in_usr_id, SYSDATE
                    );
                END IF;

                v_cng_cate_cd := v_sc_cate;
                v_cng_cate_sub_cd := v_rf_cate_sub;
                v_trsp_cng_sub_seq := v_spec_seq;

                EXECUTE IMMEDIATE om_query
                || ' WHERE BKG_NO            = '''|| in_bkg_no     ||''''
                || '    AND CNG_CATE_CD      = '''|| v_sc_cate     ||''''
                || '    AND CNG_CATE_SUB_CD  = '''|| v_rf_cate_sub ||''''
                || '    AND TRSP_CNG_SUB_SEQ =   '|| v_spec_seq;
            END LOOP;
            CLOSE BKG_SCRF;
        END IF;
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND');
    WHEN OTHERS_EXC THEN
        DBMS_OUTPUT.PUT_LINE('OTHERS_EXC');
    END;
--BKG_RF_CGO


/*
 * BKG_AWK_CGO
 * - Category : SC(Special Cargo) / Sub-Category : AW(Awkward)
 */
    BEGIN
        IF in_cate_sep_cd = 'SCAW' THEN
            OPEN BKG_SCAW;
            LOOP
                FETCH BKG_SCAW INTO v_bkg_no, v_spec_seq, v_eq_no, v_eq_tpsz_cd, v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm, v_col_n1st_rmk, v_col_n2nd_rmk;
                IF BKG_SCAW%NOTFOUND THEN
                    IF v_bkg_no IS NULL THEN
                        UPDATE TRS_TRSP_BKG_CNG SET
                              DELT_FLG = 'Y'
                            , COL_N1ST_RMK = REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(COL_N1ST_RMK, '\^', '#####'), v_div_cd, '^'), '[^^]', ''), '\^',  v_div_cd)
                            , COL_N2ND_RMK = ''
                            , LOCL_UPD_DT  = v_local_date
                            , UPD_USR_ID   = in_usr_id
                            , UPD_DT       = SYSDATE
                        WHERE BKG_NO             = in_bkg_no
                            AND CNG_CATE_CD      = v_sc_cate
                            AND CNG_CATE_SUB_CD  = v_aw_cate_sub
                            AND TRSP_CNG_SUB_SEQ = in_spcl_seq;

                        v_cng_cate_cd := v_sc_cate;
                        v_cng_cate_sub_cd := v_aw_cate_sub;
                        v_trsp_cng_sub_seq := in_spcl_seq;

                        EXECUTE IMMEDIATE om_query
                        || ' WHERE BKG_NO            = '''|| in_bkg_no         ||''''
                        || '    AND CNG_CATE_CD      = '''|| v_sc_cate            ||''''
                        || '    AND CNG_CATE_SUB_CD  = '''|| v_aw_cate_sub        ||''''
                        || '    AND TRSP_CNG_SUB_SEQ =   '|| in_spcl_seq;

                    END IF;
                    RAISE OTHERS_EXC;
                END IF;

                SELECT COUNT(*) INTO vcp_cnt FROM TRS_TRSP_BKG_CNG
                WHERE BKG_NO             = in_bkg_no
                    AND CNG_CATE_CD      = v_sc_cate
                    AND CNG_CATE_SUB_CD  = v_aw_cate_sub
                    AND TRSP_CNG_SUB_SEQ = in_spcl_seq;

                IF vcp_cnt > 0 THEN
                    UPDATE TRS_TRSP_BKG_CNG SET
                          CNG_IND_FLG        = DECODE(CNG_IND_FLG, 'Y', 'Y', DECODE(COL_N1ST_RMK||COL_N2ND_RMK, v_col_n1st_rmk||v_col_n2nd_rmk, 'N', 'Y'))
                        , COL_N1ST_RMK       = v_col_n1st_rmk
                        , COL_N2ND_RMK       = v_col_n2nd_rmk
                        , DELT_FLG           = 'N'
                        , LOCL_UPD_DT        = v_local_date
                        , UPD_USR_ID         = in_usr_id
                        , UPD_DT             = SYSDATE
                    WHERE BKG_NO             = v_bkg_no
                        AND CNG_CATE_CD      = v_sc_cate
                        AND CNG_CATE_SUB_CD  = v_aw_cate_sub
                        AND TRSP_CNG_SUB_SEQ = v_spec_seq;
                ELSE
                    INSERT INTO TRS_TRSP_BKG_CNG (
                        BKG_NO, CNG_CATE_CD, CNG_CATE_SUB_CD, TRSP_CNG_SUB_SEQ, CNTR_NO, CNTR_TPSZ_CD
                        , CNG_IND_FLG, PRMRY_COL_NM, PRMRY_COL_VAL_RMK, TBL_NM, COL_NM, COL_N1ST_RMK, COL_N2ND_RMK
                        , DELT_FLG, LOCL_CRE_DT, LOCL_UPD_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT
                    ) VALUES (
                        in_bkg_no, v_sc_cate, v_aw_cate_sub, v_spec_seq, v_eq_no, v_eq_tpsz_cd
                        , 'Y', v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm
                        , v_col_n1st_rmk, v_col_n2nd_rmk, 'N', v_local_date, v_local_date, in_usr_id, SYSDATE, in_usr_id, SYSDATE
                    );
                END IF;

                v_cng_cate_cd := v_sc_cate;
                v_cng_cate_sub_cd := v_aw_cate_sub;
                v_trsp_cng_sub_seq := v_spec_seq;

                EXECUTE IMMEDIATE om_query
                || ' WHERE BKG_NO            = '''|| in_bkg_no         ||''''
                || '    AND CNG_CATE_CD      = '''|| v_sc_cate            ||''''
                || '    AND CNG_CATE_SUB_CD  = '''|| v_aw_cate_sub        ||''''
                || '    AND TRSP_CNG_SUB_SEQ =   '|| v_spec_seq;
            END LOOP;
            CLOSE BKG_SCAW;
        END IF;

    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND');
    WHEN OTHERS_EXC THEN
        DBMS_OUTPUT.PUT_LINE('OTHERS_EXC');
    END;
--BKG_AWK_CGO


/*
 * BKG_TRO, BKG_TRO_DTL
 * - Category : AT(Appointment) / Sub-Category : AU(AISA & USA)
 */
    BEGIN
        IF in_cate_sep_cd = 'ATAI' OR in_cate_sep_cd = 'ATUS' THEN
            v_cate_sub := 'AU';
            OPEN BKG_ATAU;
            LOOP
                FETCH BKG_ATAU INTO v_bkg_no, v_spec_seq, v_eq_no, v_eq_tpsz_cd, v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm, v_col_n1st_rmk, v_col_n2nd_rmk;
                EXIT WHEN BKG_ATAU%NOTFOUND;

                BEGIN
                    SELECT TRSP_CNG_SUB_SEQ INTO vcp_trsp_cng_sub_seq FROM TRS_TRSP_BKG_CNG
                    WHERE BKG_NO              = in_bkg_no
                        AND CNG_CATE_CD       = v_at_cate
                        AND CNG_CATE_SUB_CD   = v_cate_sub
                        AND PRMRY_COL_VAL_RMK = v_prmry_col_val_rmk;
                EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND!');
                END;

                IF vcp_trsp_cng_sub_seq IS NOT NULL THEN
                    UPDATE TRS_TRSP_BKG_CNG SET
                          CNG_IND_FLG        = DECODE(CNG_IND_FLG, 'Y', 'Y', DECODE(COL_N1ST_RMK||COL_N2ND_RMK, v_col_n1st_rmk||v_col_n2nd_rmk, 'N', 'Y'))
                        , COL_N1ST_RMK       = v_col_n1st_rmk
                        , COL_N2ND_RMK       = v_col_n2nd_rmk
                        , DELT_FLG           = 'N'
                        , LOCL_UPD_DT        = v_local_date
                        , UPD_USR_ID         = in_usr_id
                        , UPD_DT             = SYSDATE
                    WHERE BKG_NO              = v_bkg_no
                        AND CNG_CATE_CD       = v_at_cate
                        AND CNG_CATE_SUB_CD   = v_cate_sub
                        AND PRMRY_COL_VAL_RMK = v_prmry_col_val_rmk;
                ELSE
                    INSERT INTO TRS_TRSP_BKG_CNG (
                        BKG_NO, CNG_CATE_CD, CNG_CATE_SUB_CD, TRSP_CNG_SUB_SEQ, CNTR_NO, CNTR_TPSZ_CD
                        , CNG_IND_FLG, PRMRY_COL_NM, PRMRY_COL_VAL_RMK, TBL_NM, COL_NM, COL_N1ST_RMK, COL_N2ND_RMK
                        , DELT_FLG, LOCL_CRE_DT, LOCL_UPD_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT
                    ) VALUES (
                        in_bkg_no, v_at_cate, v_cate_sub, v_spec_seq, v_eq_no, v_eq_tpsz_cd
                        , 'Y', v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm, v_col_n1st_rmk, v_col_n2nd_rmk
                        , 'N', v_local_date, v_local_date, in_usr_id, SYSDATE, in_usr_id, SYSDATE
                    );
                END IF;

                v_cng_cate_cd := v_at_cate;
                v_cng_cate_sub_cd := v_cate_sub;
                v_trsp_cng_sub_seq := 0;

                EXECUTE IMMEDIATE om_query
                || ' WHERE BKG_NO             = '''|| in_bkg_no         ||''''
                || '    AND CNG_CATE_CD       = '''|| v_at_cate         ||''''
                || '    AND CNG_CATE_SUB_CD   = '''|| v_cate_sub        ||''''
                || '    AND PRMRY_COL_VAL_RMK = '''|| v_prmry_col_val_rmk ||'''';

            END LOOP;
            CLOSE BKG_ATAU;
        END IF;
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND');
    END;
-- BKG_TRO, BKG_TRO_DTL End


/*
 * BKG_EUR_TRO, BKG_EUR_TRO_DTL
 * - Category : AT(Appointment) / Sub-Category : EU(EUR)
 */
    BEGIN
        IF in_cate_sep_cd = 'ATEU' THEN
            --BKG_EUR_TRO, BKG_EUR_TRO_DTL
            OPEN BKG_ATEU;
            LOOP
                FETCH BKG_ATEU INTO v_bkg_no, v_spec_seq, v_eq_no, v_eq_tpsz_cd, v_prmry_col_nm, v_prmry_col_val_rmk , v_tbl_nm, v_col_nm, v_col_n1st_rmk, v_col_n2nd_rmk;
                EXIT WHEN BKG_ATEU%NOTFOUND;
                BEGIN
                    SELECT COUNT(*) INTO vcp_cnt FROM TRS_TRSP_BKG_CNG
                    WHERE BKG_NO              = in_bkg_no
                        AND CNG_CATE_CD       = v_at_cate
                        AND CNG_CATE_SUB_CD   = v_eu_cate_sub
                        AND PRMRY_COL_VAL_RMK = v_prmry_col_val_rmk;
                END;

                IF vcp_cnt > 0 THEN
                    UPDATE TRS_TRSP_BKG_CNG SET
                          CNG_IND_FLG        = DECODE(CNG_IND_FLG, 'Y', 'Y', DECODE(COL_N1ST_RMK||COL_N2ND_RMK, v_col_n1st_rmk||v_col_n2nd_rmk, 'N', 'Y'))
                        , COL_N1ST_RMK       = v_col_n1st_rmk
                        , COL_N2ND_RMK       = v_col_n2nd_rmk
                        , DELT_FLG           = 'N'
                        , LOCL_UPD_DT        = v_local_date
                        , UPD_USR_ID         = in_usr_id
                        , UPD_DT             = SYSDATE
                    WHERE BKG_NO              = v_bkg_no
                        AND CNG_CATE_CD       = v_at_cate
                        AND CNG_CATE_SUB_CD   = v_eu_cate_sub
                        AND PRMRY_COL_VAL_RMK = v_prmry_col_val_rmk;

                ELSE
                    INSERT INTO TRS_TRSP_BKG_CNG (
                        BKG_NO, CNG_CATE_CD, CNG_CATE_SUB_CD, TRSP_CNG_SUB_SEQ, CNTR_NO, CNTR_TPSZ_CD
                        , CNG_IND_FLG, PRMRY_COL_NM, PRMRY_COL_VAL_RMK, TBL_NM, COL_NM, COL_N1ST_RMK, COL_N2ND_RMK
                        , DELT_FLG, LOCL_CRE_DT, LOCL_UPD_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT
                    ) VALUES (
                        in_bkg_no, v_at_cate, v_eu_cate_sub, v_spec_seq, v_eq_no, v_eq_tpsz_cd
                        , 'Y', v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm, v_col_n1st_rmk, v_col_n2nd_rmk
                        , 'N', v_local_date, v_local_date, in_usr_id, SYSDATE, in_usr_id, SYSDATE
                    );
                END IF;

                v_cng_cate_cd := v_at_cate;
                v_cng_cate_sub_cd := v_eu_cate_sub;
                v_trsp_cng_sub_seq := 0;

                EXECUTE IMMEDIATE om_query
                || ' WHERE BKG_NO             = '''|| in_bkg_no         ||''''
                || '    AND CNG_CATE_CD       = '''|| v_at_cate         ||''''
                || '    AND CNG_CATE_SUB_CD   = '''|| v_eu_cate_sub     ||''''
                || '    AND PRMRY_COL_VAL_RMK = '''|| v_prmry_col_val_rmk ||'''';
            END LOOP;
            CLOSE BKG_ATEU;
        END IF;

    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND');
    END;
-- BKG_EUR_TRO, BKG_EUR_TRO_DTL End


/*
 * BKG_CGO_RLSE (F,O,C)
 * - Category : CR(Special Cargo) / Sub-Category : US(USA)
 */
    BEGIN
        IF in_cate_sep_cd = 'CRUS' THEN
            --BKG_EUR_TRO, BKG_EUR_TRO_DTL
            OPEN BKG_CRUS;
            LOOP
                FETCH BKG_CRUS INTO v_bkg_no, v_spec_seq, v_eq_no, v_eq_tpsz_cd, v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm, v_col_n1st_rmk, v_col_n2nd_rmk;
                EXIT WHEN BKG_CRUS%NOTFOUND;

                SELECT COUNT(*) INTO vcp_cnt FROM TRS_TRSP_BKG_CNG
                WHERE BKG_NO              = in_bkg_no
                    AND CNG_CATE_CD       = v_cr_cate
                    AND CNG_CATE_SUB_CD   = v_us_cate_sub;

                IF vcp_cnt > 0 THEN
                    UPDATE TRS_TRSP_BKG_CNG SET
                          CNG_IND_FLG        = DECODE(CNG_IND_FLG, 'Y', 'Y', DECODE(COL_N1ST_RMK||COL_N2ND_RMK, v_col_n1st_rmk||v_col_n2nd_rmk, 'N', 'Y'))
                        , COL_N1ST_RMK       = v_col_n1st_rmk
                        , DELT_FLG           = 'N'
                        , LOCL_UPD_DT        = v_local_date
                        , UPD_USR_ID         = in_usr_id
                        , UPD_DT             = SYSDATE
                    WHERE BKG_NO              = v_bkg_no
                        AND CNG_CATE_CD       = v_cr_cate
                        AND CNG_CATE_SUB_CD   = v_us_cate_sub;
                ELSE
                    INSERT INTO TRS_TRSP_BKG_CNG (
                        BKG_NO, CNG_CATE_CD, CNG_CATE_SUB_CD, TRSP_CNG_SUB_SEQ
                        , CNG_IND_FLG, PRMRY_COL_NM, PRMRY_COL_VAL_RMK, TBL_NM, COL_NM, COL_N1ST_RMK, COL_N2ND_RMK
                        , DELT_FLG, LOCL_CRE_DT, LOCL_UPD_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT
                    ) VALUES (
                        in_bkg_no, v_cr_cate, v_us_cate_sub
                        , (SELECT NVL(MAX(TRSP_CNG_SUB_SEQ)+1, 1) FROM TRS_TRSP_BKG_CNG WHERE BKG_NO = in_bkg_no AND CNG_CATE_CD = v_cr_cate AND CNG_CATE_SUB_CD = v_us_cate_sub)
                        , 'Y', v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm
                        , v_col_n1st_rmk, v_col_n2nd_rmk, 'N', v_local_date, v_local_date, in_usr_id, SYSDATE, in_usr_id, SYSDATE
                    );
                END IF;

                v_cng_cate_cd := v_cr_cate;
                v_cng_cate_sub_cd := v_us_cate_sub;
                v_trsp_cng_sub_seq := 0;

                EXECUTE IMMEDIATE om_query
                || ' WHERE BKG_NO            = '''|| in_bkg_no          ||''''
                || '    AND CNG_CATE_CD      = '''|| v_cr_cate          ||''''
                || '    AND CNG_CATE_SUB_CD  = '''|| v_us_cate_sub      ||'''';

            END LOOP;
            CLOSE BKG_CRUS;
        END IF;

    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND');
    END;
    -- BKG_CGO_RLSE End

   /*
   * BKG_VVD
   * - Category : VV(Vessel/Voyage) / Sub-Category : Pre-VVD(SV), Trunk VVD(TV)
   * S : PRE, T : Trunk, U : Post
   * If the value is more then 2 as same 'S', the applicable PRE VVD is minimum value of VSL Sequence.
   */

    BEGIN
        IF in_cate_sep_cd = 'VVTV' OR in_cate_sep_cd = 'VVSV' THEN
            IF in_cate_sep_cd = 'VVTV' THEN v_cate_sub := v_tv_cate_sub;
            ELSE v_cate_sub := v_sv_cate_sub;
            END IF;
            OPEN BKG_VVDTS;
            LOOP
                FETCH BKG_VVDTS INTO v_bkg_no, v_spec_seq, v_eq_no, v_eq_tpsz_cd, v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm, v_col_n1st_rmk, v_col_n2nd_rmk;
                IF BKG_VVDTS%NOTFOUND THEN
                    IF v_bkg_no IS NULL THEN
                        UPDATE TRS_TRSP_BKG_CNG SET
                              DELT_FLG = 'Y'
                            , LOCL_UPD_DT  = v_local_date
                            , UPD_USR_ID   = in_usr_id
                            , UPD_DT       = SYSDATE
                        WHERE BKG_NO             = in_bkg_no
                            AND CNG_CATE_CD      = v_vv_cate
                            AND CNG_CATE_SUB_CD  = v_cate_sub;
                            
                        EXECUTE IMMEDIATE om_query
                        || ' WHERE BKG_NO            = '''|| in_bkg_no       ||''''
                        || '    AND CNG_CATE_CD      = '''|| v_vv_cate       ||''''
                        || '    AND CNG_CATE_SUB_CD  = '''|| v_cate_sub      ||'''';                           
                            
                    END IF;
                    v_cng_cate_cd := v_vv_cate;
                    v_cng_cate_sub_cd := v_cate_sub;
                    v_trsp_cng_sub_seq := 0;                    
                    RAISE OTHERS_EXC;
                END IF;

                SELECT COUNT(*) INTO vcp_cnt FROM TRS_TRSP_BKG_CNG
                WHERE BKG_NO              = in_bkg_no
                    AND CNG_CATE_CD       = v_vv_cate
                    AND CNG_CATE_SUB_CD   = v_cate_sub;

                IF vcp_cnt > 0 THEN
                    UPDATE TRS_TRSP_BKG_CNG SET
                          CNG_IND_FLG        = DECODE(CNG_IND_FLG, 'Y', 'Y', DECODE(COL_N1ST_RMK||COL_N2ND_RMK, v_col_n1st_rmk||v_col_n2nd_rmk, 'N', 'Y'))
                        , COL_N1ST_RMK       = v_col_n1st_rmk
                        , DELT_FLG           = 'N'
                        , LOCL_UPD_DT        = v_local_date
                        , UPD_USR_ID         = in_usr_id
                        , UPD_DT             = SYSDATE
                    WHERE BKG_NO              = v_bkg_no
                        AND CNG_CATE_CD       = v_vv_cate
                        AND CNG_CATE_SUB_CD   = v_cate_sub;
                ELSE
                    INSERT INTO TRS_TRSP_BKG_CNG (
                        BKG_NO, CNG_CATE_CD, CNG_CATE_SUB_CD, TRSP_CNG_SUB_SEQ
                        , CNG_IND_FLG, PRMRY_COL_NM, PRMRY_COL_VAL_RMK, TBL_NM, COL_NM, COL_N1ST_RMK, COL_N2ND_RMK
                        , DELT_FLG, LOCL_CRE_DT, LOCL_UPD_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT
                    ) VALUES (
                        in_bkg_no, v_vv_cate, v_cate_sub
                        , (SELECT NVL(MAX(TRSP_CNG_SUB_SEQ)+1, 1) FROM TRS_TRSP_BKG_CNG WHERE BKG_NO = in_bkg_no AND CNG_CATE_CD = v_vv_cate AND CNG_CATE_SUB_CD = v_cate_sub)
                        , 'Y', v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm
                        , v_col_n1st_rmk, v_col_n2nd_rmk, 'N', v_local_date, v_local_date, in_usr_id, SYSDATE, in_usr_id, SYSDATE
                    );
                END IF;

                v_cng_cate_cd := v_vv_cate;
                v_cng_cate_sub_cd := v_cate_sub;
                v_trsp_cng_sub_seq := 0;

                EXECUTE IMMEDIATE om_query
                || ' WHERE BKG_NO            = '''|| in_bkg_no       ||''''
                || '    AND CNG_CATE_CD      = '''|| v_vv_cate       ||''''
                || '    AND CNG_CATE_SUB_CD  = '''|| v_cate_sub      ||'''';

            END LOOP;
            CLOSE BKG_VVDTS;
        END IF;

    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND');
    WHEN OTHERS_EXC THEN
        DBMS_OUTPUT.PUT_LINE('OTHERS_EXC');
    END;
-- BKG_VVD End


/*
 * BKG_BOOKING
 * - Category : CN(Cargo Nature) / Sub-Category : CN(Dangerous, Reefer, Awkward Flag)
 */
    BEGIN
        IF in_cate_sep_cd = 'CNCN' THEN
            OPEN BKG_CNCN;
            LOOP
                FETCH BKG_CNCN INTO v_bkg_no, v_spec_seq, v_eq_no, v_eq_tpsz_cd, v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm, v_col_n1st_rmk, v_col_n2nd_rmk;
                EXIT WHEN BKG_CNCN%NOTFOUND;

                SELECT COUNT(*) INTO vcp_cnt FROM TRS_TRSP_BKG_CNG
                WHERE BKG_NO              = in_bkg_no
                    AND CNG_CATE_CD       = v_cn_cate
                    AND CNG_CATE_SUB_CD   = v_cn_cate_sub;

                IF vcp_cnt > 0 THEN
                   UPDATE TRS_TRSP_BKG_CNG SET
                          CNG_IND_FLG        = DECODE(CNG_IND_FLG, 'Y', 'Y', DECODE(COL_N1ST_RMK||COL_N2ND_RMK, v_col_n1st_rmk||v_col_n2nd_rmk, 'N', 'Y'))
                        , COL_N1ST_RMK       = v_col_n1st_rmk
                        , DELT_FLG           = 'N'
                        , LOCL_UPD_DT        = v_local_date
                        , UPD_USR_ID         = in_usr_id
                        , UPD_DT             = SYSDATE
                    WHERE BKG_NO              = v_bkg_no
                        AND CNG_CATE_CD       = v_cn_cate
                        AND CNG_CATE_SUB_CD   = v_cn_cate_sub;
                ELSE
                    INSERT INTO TRS_TRSP_BKG_CNG (
                        BKG_NO, CNG_CATE_CD, CNG_CATE_SUB_CD, TRSP_CNG_SUB_SEQ
                        , CNG_IND_FLG, PRMRY_COL_NM, PRMRY_COL_VAL_RMK, TBL_NM, COL_NM, COL_N1ST_RMK, COL_N2ND_RMK
                        , DELT_FLG, LOCL_CRE_DT, LOCL_UPD_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT
                    ) VALUES (
                        in_bkg_no, v_cn_cate, v_cn_cate_sub
                        , (SELECT NVL(MAX(TRSP_CNG_SUB_SEQ)+1, 1) FROM TRS_TRSP_BKG_CNG WHERE BKG_NO = in_bkg_no AND CNG_CATE_CD = v_cn_cate AND CNG_CATE_SUB_CD = v_cn_cate_sub)
                        , 'Y', v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm
                        , v_col_n1st_rmk, v_col_n2nd_rmk, 'N', v_local_date, v_local_date, in_usr_id, SYSDATE, in_usr_id, SYSDATE
                    );
                END IF;
                v_cng_cate_cd := v_cn_cate;
                v_cng_cate_sub_cd := v_cn_cate_sub;
                v_trsp_cng_sub_seq := 0;

                EXECUTE IMMEDIATE om_query
                || ' WHERE BKG_NO            = '''|| in_bkg_no       ||''''
                || '    AND CNG_CATE_CD      = '''|| v_cn_cate       ||''''
                || '    AND CNG_CATE_SUB_CD  = '''|| v_cn_cate_sub   ||'''';

            END LOOP;
            CLOSE BKG_CNCN;
        END IF;

    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND');
    END;

/*
 * Booking Cut Off Time
 * Category : CT(Cut Off Time) / Sub-Category : PO(Port Cut Off), IN(Inland Cut Off)
 */
    BEGIN
        IF in_cate_sep_cd IN('CTPO', 'CTIN', 'CUFF') THEN
            v_cu_cate := SUBSTR(in_cate_sep_cd, 1, 2);
            v_ff_cate_sub := SUBSTR(in_cate_sep_cd, 3, 2);
            p_clz_tp_cd := 'R';

            IF in_cate_sep_cd IN ('CTPO', 'CUFF') THEN p_clz_tp_cd := 'T'; END IF;
            OPEN BKG_CUFF(p_clz_tp_cd);
            LOOP
                FETCH BKG_CUFF INTO v_bkg_no, v_spec_seq, v_eq_no, v_eq_tpsz_cd, v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm, v_col_n1st_rmk, v_col_n2nd_rmk;
                EXIT WHEN BKG_CUFF%NOTFOUND;

                SELECT COUNT(*) INTO vcp_cnt FROM TRS_TRSP_BKG_CNG
                WHERE BKG_NO              = in_bkg_no
                    AND CNG_CATE_CD       = v_cu_cate
                    AND CNG_CATE_SUB_CD   = v_ff_cate_sub;

                IF vcp_cnt > 0 THEN
                   UPDATE TRS_TRSP_BKG_CNG SET
                          CNG_IND_FLG        = DECODE(CNG_IND_FLG, 'Y', 'Y', DECODE(COL_N1ST_RMK||COL_N2ND_RMK, v_col_n1st_rmk||v_col_n2nd_rmk, 'N', 'Y'))
                        , COL_N1ST_RMK       = v_col_n1st_rmk
                        , DELT_FLG           = 'N'
                        , LOCL_UPD_DT        = v_local_date
                        , UPD_USR_ID         = in_usr_id
                        , UPD_DT             = SYSDATE
                    WHERE BKG_NO              = v_bkg_no
                        AND CNG_CATE_CD       = v_cu_cate
                        AND CNG_CATE_SUB_CD   = v_ff_cate_sub;
                ELSE
                    INSERT INTO TRS_TRSP_BKG_CNG (
                        BKG_NO, CNG_CATE_CD, CNG_CATE_SUB_CD, TRSP_CNG_SUB_SEQ
                        , CNG_IND_FLG, PRMRY_COL_NM, PRMRY_COL_VAL_RMK, TBL_NM, COL_NM, COL_N1ST_RMK, COL_N2ND_RMK
                        , DELT_FLG, LOCL_CRE_DT, LOCL_UPD_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT
                    ) VALUES (
                        in_bkg_no, v_cu_cate, v_ff_cate_sub
                        , (SELECT NVL(MAX(TRSP_CNG_SUB_SEQ)+1, 1) FROM TRS_TRSP_BKG_CNG WHERE BKG_NO = in_bkg_no AND CNG_CATE_CD = v_cu_cate AND CNG_CATE_SUB_CD = v_ff_cate_sub)
                        , 'Y', v_prmry_col_nm, v_prmry_col_val_rmk, v_tbl_nm, v_col_nm
                        , v_col_n1st_rmk, v_col_n2nd_rmk, 'N', v_local_date, v_local_date, in_usr_id, SYSDATE, in_usr_id, SYSDATE
                    );
                END IF;
                v_cng_cate_cd := v_cu_cate;
                v_cng_cate_sub_cd := v_ff_cate_sub;
                v_trsp_cng_sub_seq := 0;
                EXECUTE IMMEDIATE om_query
                || ' WHERE BKG_NO            = '''|| in_bkg_no       ||''''
                || '    AND CNG_CATE_CD      = '''|| v_cu_cate       ||''''
                || '    AND CNG_CATE_SUB_CD  = '''|| v_ff_cate_sub   ||'''';

            END LOOP;
            CLOSE BKG_CUFF;
        END IF;

    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND');
    END;
-- BKG_BOOKING End

-- Final change indicate flag updating
  for tmp_chg in
    (SELECT    A.TRSP_SO_OFC_CTY_CD
              ,A.TRSP_SO_SEQ
              ,A.TRSP_SO_SUB_SEQ
              ,A.BKG_NO
              ,A.EQ_NO
              ,B.TRSP_CNG_SUB_SEQ
              ,B.CNG_CATE_CD
              ,B.CNG_CATE_SUB_CD
              ,B.COL_N1ST_RMK AS PRE_COL_N1ST_RMK
              ,B.COL_N2ND_RMK AS PRE_COL_N2ND_RMK
              ,DECODE(NVL(B.DELT_FLG, 'N') , 'N', B.COL_N1ST_RMK, 'Y', REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(B.COL_N1ST_RMK, '\^', '#####'), '@#@', '^'), '[^^]', ''), '\^',  '@#@'))  COL_N1ST_RMK
              ,DECODE(NVL(B.DELT_FLG, 'N') , 'N', B.COL_N2ND_RMK, 'Y', '') COL_N2ND_RMK
              ,NVL(B.DELT_FLG, 'N') AS DELT_FLG
              ,C.TRSP_BND_CD
              ,C.TRSP_COST_DTL_MOD_CD
            FROM TRS_TRSP_SVC_ORD_CNG A
                ,TRS_TRSP_BKG_CNG     B
                ,TRS_TRSP_SVC_ORD     C
             WHERE A.BKG_NO = B.BKG_NO
             AND A.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD
             AND A.TRSP_SO_SEQ = C.TRSP_SO_SEQ
             AND C.DELT_FLG = 'N'
             AND B.BKG_NO = in_bkg_no
             AND B.CNG_CATE_CD = v_cng_cate_cd
             AND B.CNG_CATE_SUB_CD = v_cng_cate_sub_cd
             AND B.TRSP_CNG_SUB_SEQ = decode(v_trsp_cng_sub_seq, 0, B.TRSP_CNG_SUB_SEQ, v_trsp_cng_sub_seq)
             AND DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATAU', NVL(C.BKG_NO, 'XX'), 'XX') = DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATAU', NVL(REGEXP_SUBSTR(B.PRMRY_COL_VAL_RMK, '[^@#@]+', 1, 1), 'XX'), 'XX')
             AND DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATAU', NVL(C.TRSP_BND_CD, 'X'), 'X') = DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATAU', NVL(REGEXP_SUBSTR(B.PRMRY_COL_VAL_RMK, '[^@#@]+', 1, 2), 'X'), 'X')
             AND DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATAU', NVL(C.TRO_SEQ, 0), 0) = DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATAU', NVL(REGEXP_SUBSTR(B.PRMRY_COL_VAL_RMK, '[^@#@]+', 1, 4), 0), 0)
             AND DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATAU', NVL(C.TRO_SUB_SEQ, 0), 0) = DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATAU', NVL(REGEXP_SUBSTR(B.PRMRY_COL_VAL_RMK, '[^@#@]+', 1, 5), 0), 0)
             AND DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATEU', NVL(C.BKG_NO, 'XX'), 'XX') = DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATEU', NVL(REGEXP_SUBSTR(B.PRMRY_COL_VAL_RMK, '[^@#@]+', 1, 1), 'XX'), 'XX')
             AND DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATEU', NVL(C.TRSP_BND_CD, 'X'), 'X') = DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATEU', NVL(REGEXP_SUBSTR(B.PRMRY_COL_VAL_RMK, '[^@#@]+', 1, 2), 'X'), 'X')
             AND DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATEU', NVL(C.TRO_SEQ, 0), 0) = DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATEU', NVL(REGEXP_SUBSTR(B.PRMRY_COL_VAL_RMK, '[^@#@]+', 1, 3), 0), 0)
             AND DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATEU', NVL(C.TRO_SUB_SEQ, 0), 0) = DECODE(B.CNG_CATE_CD || B.CNG_CATE_SUB_CD, 'ATEU', NVL(REGEXP_SUBSTR(B.PRMRY_COL_VAL_RMK, '[^@#@]+', 1, 4), 0), 0)
     ) loop

     IF tmp_chg.CNG_CATE_CD || tmp_chg.CNG_CATE_SUB_CD = 'CRUS' AND tmp_chg.TRSP_BND_CD <> 'I' THEN CONTINUE; END IF;

     merge into trs_trsp_svc_ord_bkg_cng k
     using dual
     on (k.trsp_so_ofc_cty_cd = tmp_chg.trsp_so_ofc_cty_cd and k.trsp_so_seq = tmp_chg.trsp_so_seq and k.trsp_so_sub_seq = tmp_chg.trsp_so_sub_seq and k.bkg_no = tmp_chg.bkg_no and k.cng_cate_cd = tmp_chg.cng_cate_cd and k.cng_cate_sub_cd = tmp_chg.cng_cate_sub_cd and k.trsp_cng_sub_seq = tmp_chg.trsp_cng_sub_seq)
     when matched then
          update
          set  COL_N1ST_RMK = tmp_chg.COL_N1ST_RMK
              ,COL_N2ND_RMK = tmp_chg.COL_N2ND_RMK
              ,CNG_IND_FLG = decode(nvl(tmp_chg.COL_N1ST_RMK,'x') || nvl(tmp_chg.COL_N2ND_RMK,'x'), nvl(k.PRE_COL_N1ST_RMK, 'x') || nvl(k.PRE_COL_N2ND_RMK, 'x'), 'N', 'Y')
              ,UPD_USR_ID   = in_usr_id
              ,UPD_DT       = sysdate
    when not matched then
         insert (
             TRSP_SO_OFC_CTY_CD
            ,TRSP_SO_SEQ
            ,TRSP_SO_SUB_SEQ
            ,BKG_NO
            ,CNG_CATE_CD
            ,CNG_CATE_SUB_CD
            ,TRSP_CNG_SUB_SEQ
            ,COL_N1ST_RMK
            ,COL_N2ND_RMK
            ,PRE_COL_N1ST_RMK
            ,PRE_COL_N2ND_RMK
            ,CNG_IND_FLG
            ,CRE_USR_ID
            ,CRE_DT
            ,UPD_USR_ID
            ,UPD_DT
          ) values (
             tmp_chg.TRSP_SO_OFC_CTY_CD
            ,tmp_chg.TRSP_SO_SEQ
            ,tmp_chg.TRSP_SO_SUB_SEQ
            ,tmp_chg.BKG_NO
            ,tmp_chg.CNG_CATE_CD
            ,tmp_chg.CNG_CATE_SUB_CD
            ,tmp_chg.TRSP_CNG_SUB_SEQ
            ,tmp_chg.COL_N1ST_RMK
            ,tmp_chg.COL_N2ND_RMK
            ,REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(tmp_chg.PRE_COL_N1ST_RMK, '\^', '#####'), v_div_cd, '^'), '[^^]', ''), '\^',  v_div_cd)
            ,tmp_chg.PRE_COL_N2ND_RMK
            ,'Y'
            ,in_usr_id
            ,sysdate
            ,in_usr_id
            ,sysdate
          );
  end loop;

  BEGIN
    UPDATE TRS_TRSP_SVC_ORD_CNG SO
    SET SO.CNG_IND_FLG =(
                select max(o.cng_ind_flg)
                  from trs_trsp_svc_ord_bkg_cng o
                where o.trsp_so_ofc_cty_cd = so.trsp_so_ofc_cty_cd
                and o.trsp_so_seq=so.trsp_so_seq
                and o.trsp_so_sub_seq=so.trsp_so_sub_seq
                and o.bkg_no = so.bkg_no
              )
    WHERE SO.BKG_NO = in_bkg_no;
  END;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('-> OTHERS');
END TRS_CHG_MGT_BKG_PRC;
