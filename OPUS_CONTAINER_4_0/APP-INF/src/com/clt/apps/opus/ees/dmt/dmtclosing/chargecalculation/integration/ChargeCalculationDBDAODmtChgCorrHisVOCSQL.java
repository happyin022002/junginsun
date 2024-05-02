/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAODmtChgCorrHisVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAODmtChgCorrHisVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ChargeCalculationDBDAODmtChgCorrHisVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_his_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAODmtChgCorrHisVOCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_CHG_CORR_HIS (" ).append("\n"); 
		query.append("	SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_CYC_NO" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",	CHG_SEQ" ).append("\n"); 
		query.append(",	CORR_HIS_SEQ" ).append("\n"); 
		query.append(",	FM_MVMT_STS_CD" ).append("\n"); 
		query.append(",	FM_MVMT_DT" ).append("\n"); 
		query.append(",	FM_YD_CD" ).append("\n"); 
		query.append(",	TO_MVMT_STS_CD" ).append("\n"); 
		query.append(",	TO_MVMT_DT" ).append("\n"); 
		query.append(",	TO_YD_CD" ).append("\n"); 
		query.append(",	CHG_STS_CD" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	WEB_CRE_USR_ID" ).append("\n"); 
		query.append(",	WEB_CRE_DT" ).append("\n"); 
		query.append(",	WEB_MTY_DT" ).append("\n"); 
		query.append(",	WEB_NTFY_PIC_NM" ).append("\n"); 
		query.append(",	CORR_HIS_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",	C.CNTR_NO" ).append("\n"); 
		query.append(",	C.CNTR_CYC_NO" ).append("\n"); 
		query.append(",	C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",	C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",	C.CHG_SEQ" ).append("\n"); 
		query.append(",	@[corr_his_seq]" ).append("\n"); 
		query.append(",	C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append(",	C.FM_MVMT_DT" ).append("\n"); 
		query.append(",	C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",	C.TO_MVMT_STS_CD" ).append("\n"); 
		query.append(",	C.TO_MVMT_DT" ).append("\n"); 
		query.append(",	C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",	C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",	B.BKG_NO" ).append("\n"); 
		query.append(",	C.WEB_CRE_USR_ID" ).append("\n"); 
		query.append(",	C.WEB_CRE_DT" ).append("\n"); 
		query.append(",	C.WEB_MTY_DT" ).append("\n"); 
		query.append(",	C.WEB_NTFY_PIC_NM" ).append("\n"); 
		query.append(",	DECODE(@[corr_his_seq],	'1',	C.CORR_RMK,		@[corr_his_rmk])" ).append("\n"); 
		query.append(",	DECODE(@[corr_his_seq],	'1',	C.CRE_USR_ID,	@[cre_usr_id])" ).append("\n"); 
		query.append(",	DECODE(@[corr_his_seq],	'1',	C.CRE_DT,		SYSDATE)" ).append("\n"); 
		query.append(",	DECODE(@[corr_his_seq],	'1',	C.CRE_OFC_CD,	@[cre_ofc_cd])" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_ofc_cd]" ).append("\n"); 
		query.append("FROM     DMT_CHG_CALC        C" ).append("\n"); 
		query.append("		,DMT_CHG_BKG_CNTR    B" ).append("\n"); 
		query.append("WHERE	" ).append("\n"); 
		query.append("	C.SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("AND	C.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND	C.CNTR_CYC_NO		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND	C.DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND	C.DMDT_CHG_LOC_DIV_CD  = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND	C.CHG_SEQ			= @[chg_seq]" ).append("\n"); 
		query.append("AND	B.SYS_AREA_GRP_ID	= C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND	B.CNTR_NO			= C.CNTR_NO" ).append("\n"); 
		query.append("AND	B.CNTR_CYC_NO		= C.CNTR_CYC_NO" ).append("\n"); 

	}
}