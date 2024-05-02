/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchDiscCYBondInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.12 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchDiscCYBondInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Discharge CY, Bonded Warehouse, Bonded Type 등 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchDiscCYBondInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchDiscCYBondInfoRSQL").append("\n");
		query.append("*/").append("\n");
	}

	public String getSQL(){
		return query.toString();
	}

	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD VVD," ).append("\n");
		query.append("DECODE(SEQ.MRN_BL_TS_CD,'I','LOCAL','E','LOCAL','T','T/S','R','T/S') LOCAL_TS," ).append("\n");
		query.append("SEQ.MRN_BL_TS_CD MRN_BL_TS_CD," ).append("\n");
		query.append("SEQ.MF_REF_NO MF_REF_NO," ).append("\n");
		query.append("SEQ.MRN_CHK_NO MRN_CHK_NO," ).append("\n");
		query.append("SEQ.MF_SEQ_NO MF_SEQ_NO," ).append("\n");
		query.append("SEQ.MF_CFM_FLG  MF_CFM_FLG," ).append("\n");
		query.append("' ' CNEE," ).append("\n");
		query.append("' ' NFTY," ).append("\n");
		query.append("DOC.PCK_QTY PCK_QTY," ).append("\n");
		query.append("DOC.PCK_TP_CD PCK_TP_CD," ).append("\n");
		query.append("DOC.ACT_WGT ACT_WGT," ).append("\n");
		query.append("DOC.WGT_UT_CD WGT_UT_CD," ).append("\n");
		query.append("DOC.MEAS_QTY MEAS_QTY," ).append("\n");
		query.append("DOC.MEAS_UT_CD MEAS_UT_CD," ).append("\n");
		query.append("' ' CSTMS_DESC," ).append("\n");
		query.append("SEQ.CSTMS_CLR_TP_CD CSTMS_CLR_TP_CD," ).append("\n");
		query.append("SEQ.CSTMS_DCHG_LOC_WH_CD CSTMS_DCHG_LOC_WH_CD," ).append("\n");
		query.append("' ' LOC_NM," ).append("\n");
		query.append("SEQ.KR_CSTMS_BL_TP_CD KR_CSTMS_BL_TP_CD," ).append("\n");
		query.append("SEQ.CSTMS_CLR_WH_CD CSTMS_CLR_WH_CD," ).append("\n");
		query.append("WH.WH_NM WH_NM," ).append("\n");
		query.append("WH.LOC_CD LOC_CD," ).append("\n");
		query.append("SEQ.BD_TP_CD BD_TP_CD," ).append("\n");
		query.append("SEQ.BKG_NO BKG_NO," ).append("\n");
		query.append("NVL(BKG.BL_NO,' ') BL_NO," ).append("\n");
		query.append("SEQ.CSTMS_CLR_LOC_CD CSTMS_CLR_LOC_CD," ).append("\n");
		query.append("BKG.DEL_CD DEL_CD," ).append("\n");
		query.append("BKG.POD_CD POD_CD," ).append("\n");
		query.append("BKG.POL_CD POL_CD," ).append("\n");
		query.append("DECODE(ELNO.XPT_LIC_NO,NULL,'N',' ','N','Y') XPT_LIC_NO" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_MF_SEQ_NO SEQ, BKG_BOOKING BKG, BKG_WAREHOUSE WH, BKG_XPT_IMP_LIC ELNO, BKG_CSTMS_KR_MF_REF_NO REF, BKG_BL_DOC DOC" ).append("\n");
		query.append("WHERE SEQ.BKG_NO         =  @[bkg_no]" ).append("\n");
		query.append("AND   SEQ.MF_REF_NO      =  REF.MRN_NO" ).append("\n");
		query.append("AND   SEQ.BKG_NO         =  BKG.BKG_NO" ).append("\n");
		query.append("AND   REF.IO_BND_CD      =  @[io_bnd_cd]" ).append("\n");
		query.append("AND   BKG.BKG_NO         =  ELNO.BKG_NO(+)" ).append("\n");
		query.append("AND   BKG.BKG_NO         =  DOC.BKG_NO" ).append("\n");
		query.append("AND   SEQ.CSTMS_CLR_WH_CD= WH.CSTMS_CD(+)" ).append("\n");
		query.append("AND   SEQ.MF_CFM_FLG     = 'Y'" ).append("\n");
		query.append("AND   WH.CNT_CD(+)       = 'KR'" ).append("\n");
		query.append("AND   SEQ.CFM_DT = (SELECT MAX(SEQ.CFM_DT)" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_MF_SEQ_NO SEQ, BKG_DCHG_LOC DISC," ).append("\n");
		query.append("BKG_BOOKING BKG, BKG_WAREHOUSE WH," ).append("\n");
		query.append("BKG_XPT_IMP_LIC ELNO, BKG_CSTMS_KR_MF_REF_NO REF" ).append("\n");
		query.append("WHERE SEQ.BKG_NO     =  @[bkg_no]" ).append("\n");
		query.append("AND   SEQ.MF_REF_NO  =  REF.MRN_NO" ).append("\n");
		query.append("AND   SEQ.BKG_NO     =  BKG.BKG_NO" ).append("\n");
		query.append("AND   REF.IO_BND_CD  =  @[io_bnd_cd]" ).append("\n");
		query.append("AND   BKG.BKG_NO     =  ELNO.BKG_NO(+)" ).append("\n");
		query.append("AND   SEQ.CSTMS_DCHG_LOC_WH_CD    = DISC.OTR_DCHG_CD(+)" ).append("\n");
		query.append("AND   SEQ.CSTMS_CLR_WH_CD    = WH.CSTMS_CD(+)" ).append("\n");
		query.append("AND   SEQ.MF_CFM_FLG = 'Y'" ).append("\n");
		query.append("AND   WH.CNT_CD(+)      = 'KR')" ).append("\n");

	}
}