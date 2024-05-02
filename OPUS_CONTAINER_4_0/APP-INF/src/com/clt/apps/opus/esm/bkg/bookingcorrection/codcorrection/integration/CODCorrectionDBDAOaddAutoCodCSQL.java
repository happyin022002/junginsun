/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CODCorrectionDBDAOaddAutoCodCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.24
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.08.24 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOaddAutoCodCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Creation, E-BKG/SI Upload 화면에서 Auto COD를 Insert한다
	  * </pre>
	  */
	public CODCorrectionDBDAOaddAutoCodCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rso_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rhnd_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOaddAutoCodCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_COD (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	COD_RQST_SEQ" ).append("\n"); 
		query.append(",	COD_STS_CD " ).append("\n"); 
		query.append(",   COD_ISS_DT" ).append("\n"); 
		query.append(",	COD_RQST_RSN_CD" ).append("\n"); 
		query.append(",	RGN_CD" ).append("\n"); 
		query.append(",	OLD_VSL_CD" ).append("\n"); 
		query.append(",	OLD_SKD_VOY_NO" ).append("\n"); 
		query.append(",	OLD_SKD_DIR_CD" ).append("\n"); 
		query.append(",	OLD_POR_YD_CD" ).append("\n"); 
		query.append(",	OLD_POL_YD_CD" ).append("\n"); 
		query.append(",	OLD_POD_YD_CD" ).append("\n"); 
		query.append(",	OLD_DEL_YD_CD" ).append("\n"); 
		query.append(",   OLD_DE_TERM_CD" ).append("\n"); 
		query.append(",	NEW_VSL_CD" ).append("\n"); 
		query.append(",	NEW_SKD_VOY_NO" ).append("\n"); 
		query.append(",	NEW_SKD_DIR_CD" ).append("\n"); 
		query.append(",	NEW_POR_YD_CD" ).append("\n"); 
		query.append(",	NEW_POL_YD_CD" ).append("\n"); 
		query.append(",	NEW_POD_YD_CD" ).append("\n"); 
		query.append(",	NEW_DEL_YD_CD" ).append("\n"); 
		query.append(",   NEW_DE_TERM_CD" ).append("\n"); 
		query.append(",	COD_RHND_PORT_CD" ).append("\n"); 
		query.append(",	COD_RHND_PORT_YD_CD" ).append("\n"); 
		query.append(",	COD_RQST_OFC_CD" ).append("\n"); 
		query.append(",	COD_AUTH_FLG" ).append("\n"); 
		query.append(",	PCTL_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(", 	COD_MNL_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("SELECT 	BK.BKG_NO" ).append("\n"); 
		query.append("    ,	NVL((SELECT MAX(COD_RQST_SEQ) + 1 FROM BKG_COD SEQ WHERE SEQ.BKG_NO = BK.BKG_NO), 1) COD_RQST_SEQ" ).append("\n"); 
		query.append("    ,	null COD_STS_CD" ).append("\n"); 
		query.append("    ,   GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,BKG_COM_USER_LOC_FNC(@[usr_id])) COD_ISS_DT" ).append("\n"); 
		query.append("    ,	@[cod_rqst_rsn_cd] COD_RQST_RSN_CD" ).append("\n"); 
		query.append("    ,	@[rso_cd] RGN_CD" ).append("\n"); 
		query.append("    ,	BK.VSL_CD" ).append("\n"); 
		query.append("    ,	BK.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,	BK.SKD_DIR_CD" ).append("\n"); 
		query.append("    ,	BK.POR_NOD_CD" ).append("\n"); 
		query.append("    ,	BK.POL_NOD_CD" ).append("\n"); 
		query.append("    ,	BK.POD_NOD_CD" ).append("\n"); 
		query.append("    ,	BK.DEL_NOD_CD" ).append("\n"); 
		query.append("    ,	BK.DE_TERM_CD" ).append("\n"); 
		query.append("    ,	HIS.VSL_CD" ).append("\n"); 
		query.append("    ,	HIS.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,	HIS.SKD_DIR_CD" ).append("\n"); 
		query.append("    ,	HIS.POR_NOD_CD" ).append("\n"); 
		query.append("    ,	HIS.POL_NOD_CD" ).append("\n"); 
		query.append("    ,	HIS.POD_NOD_CD" ).append("\n"); 
		query.append("    ,	HIS.DEL_NOD_CD" ).append("\n"); 
		query.append("    ,   HIS.DE_TERM_CD" ).append("\n"); 
		query.append("    ,	SUBSTR(@[cod_rhnd_port_cd], 1, 5) COD_RHND_PORT_CD" ).append("\n"); 
		query.append("    ,	@[cod_rhnd_port_cd] COD_RHND_PORT_YD_CD" ).append("\n"); 
		query.append("    ,	(select ofc_cd from com_user usr where upper(usr.usr_id) = upper(@[usr_id])) COD_RQST_OFC_CD" ).append("\n"); 
		query.append("    ,	'N' COD_AUTH_FLG" ).append("\n"); 
		query.append("    ,	HIS.PCTL_NO" ).append("\n"); 
		query.append("    ,	@[usr_id]" ).append("\n"); 
		query.append("    ,	SYSDATE" ).append("\n"); 
		query.append("    ,	@[usr_id]" ).append("\n"); 
		query.append("    ,	SYSDATE" ).append("\n"); 
		query.append("    , 	'N'" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, BKG_BKG_HIS HIS" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO = HIS.BKG_NO" ).append("\n"); 
		query.append("AND HIS.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT 	BK.BKG_NO" ).append("\n"); 
		query.append("    ,	NVL((SELECT MAX(COD_RQST_SEQ) + 1 FROM BKG_COD SEQ WHERE SEQ.BKG_NO = BK.BKG_NO), 1) COD_RQST_SEQ" ).append("\n"); 
		query.append("    ,	null COD_STS_CD" ).append("\n"); 
		query.append("    ,   GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,BKG_COM_USER_LOC_FNC(@[usr_id])) COD_ISS_DT" ).append("\n"); 
		query.append("    ,	@[cod_rqst_rsn_cd] COD_RQST_RSN_CD" ).append("\n"); 
		query.append("    ,	@[rso_cd] RGN_CD" ).append("\n"); 
		query.append("    ,	BK.VSL_CD" ).append("\n"); 
		query.append("    ,	BK.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,	BK.SKD_DIR_CD" ).append("\n"); 
		query.append("    ,	BK.POR_NOD_CD" ).append("\n"); 
		query.append("    ,	BK.POL_NOD_CD" ).append("\n"); 
		query.append("    ,	BK.POD_NOD_CD" ).append("\n"); 
		query.append("    ,	BK.DEL_NOD_CD" ).append("\n"); 
		query.append("    ,	BK.DE_TERM_CD" ).append("\n"); 
		query.append("    ,	PRD.TRNK_VSL_CD" ).append("\n"); 
		query.append("    ,	PRD.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("    ,	PRD.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("    ,	PRD.POR_NOD_CD" ).append("\n"); 
		query.append("    ,	PRD.POL_NOD_CD" ).append("\n"); 
		query.append("    ,	PRD.POD_NOD_CD" ).append("\n"); 
		query.append("    ,	PRD.DEL_NOD_CD" ).append("\n"); 
		query.append("    ,   PRD.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("    ,	SUBSTR(@[cod_rhnd_port_cd], 1, 5) COD_RHND_PORT_CD" ).append("\n"); 
		query.append("    ,	@[cod_rhnd_port_cd] COD_RHND_PORT_YD_CD" ).append("\n"); 
		query.append("    ,	(select ofc_cd from com_user usr where upper(usr.usr_id) = upper(@[usr_id])) COD_RQST_OFC_CD" ).append("\n"); 
		query.append("    ,	'N' COD_AUTH_FLG" ).append("\n"); 
		query.append("    ,	PRD.PCTL_NO" ).append("\n"); 
		query.append("    ,	@[usr_id]" ).append("\n"); 
		query.append("    ,	SYSDATE" ).append("\n"); 
		query.append("    ,	@[usr_id]" ).append("\n"); 
		query.append("    ,	SYSDATE" ).append("\n"); 
		query.append("    , 	'N'" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, PRD_PROD_CTL_MST PRD" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND PRD.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}