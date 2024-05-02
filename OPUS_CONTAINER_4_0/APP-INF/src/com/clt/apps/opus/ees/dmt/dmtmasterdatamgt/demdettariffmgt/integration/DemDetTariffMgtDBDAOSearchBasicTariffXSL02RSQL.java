/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchBasicTariffXSL02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2010.01.07 문중철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mun Jung Cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchBasicTariffXSL02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 11111
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchBasicTariffXSL02RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cvrg_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchBasicTariffXSL02RSQL").append("\n"); 
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
		query.append("SELECT DISTINCT X.* FROM (" ).append("\n"); 
		query.append("SELECT B.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(", B.DMDT_TRF_CD" ).append("\n"); 
		query.append(", B.TRF_SEQ" ).append("\n"); 
		query.append(", B.TRF_GRP_SEQ" ).append("\n"); 
		query.append(", B.DMDT_BZC_TRF_GRP_NM" ).append("\n"); 
		query.append(", TO_CHAR(B.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(", NVL(TO_CHAR(B.EXP_DT,'YYYY-MM-DD'), ' ') AS EXP_DT" ).append("\n"); 
		query.append(", DECODE(B.UPD_OFC_CD, NULL, B.CRE_OFC_CD, B.UPD_OFC_CD) AS USER_OFFICE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", B.DMDT_CHG_CMNC_TP_CD" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01964' AND INTG_CD_VAL_CTNT = B.DMDT_CHG_CMNC_TP_CD )||' '||B.CMNC_HR||' HR' AS DMDT_CHG_CMNC_TP_NM" ).append("\n"); 
		query.append(", B.XCLD_SAT_FLG" ).append("\n"); 
		query.append(", B.XCLD_SUN_FLG" ).append("\n"); 
		query.append(", B.XCLD_HOL_FLG" ).append("\n"); 
		query.append(",CASE WHEN TO_CHAR(B.EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD') THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END EXPIRE_CHK" ).append("\n"); 
		query.append(",CASE WHEN (SELECT WKND_TP_CD FROM DMT_WEEKEND WHERE CNT_CD = @[cnt_cd]) = 'TF' THEN 'THU'" ).append("\n"); 
		query.append("WHEN (SELECT WKND_TP_CD FROM DMT_WEEKEND WHERE CNT_CD = @[cnt_cd]) = 'FS' THEN 'FRI'" ).append("\n"); 
		query.append("ELSE 'SAT'" ).append("\n"); 
		query.append("END WKND1" ).append("\n"); 
		query.append(",CASE WHEN (SELECT WKND_TP_CD FROM DMT_WEEKEND WHERE CNT_CD = @[cnt_cd]) = 'TF' THEN 'FRI'" ).append("\n"); 
		query.append("WHEN (SELECT WKND_TP_CD FROM DMT_WEEKEND WHERE CNT_CD = @[cnt_cd]) = 'FS' THEN 'SAT'" ).append("\n"); 
		query.append("ELSE 'SUN'" ).append("\n"); 
		query.append("END WKND2" ).append("\n"); 
		query.append(", B.CMNC_HR" ).append("\n"); 
		query.append(", B.CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DMT_TRF_RGN A, DMT_TRF_GRP B, DMT_TRF_CMB C, COM_INTG_CD_DTL D, COM_INTG_CD_DTL E" ).append("\n"); 
		query.append("WHERE A.SYS_AREA_GRP_ID= B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND A.TRF_SEQ = B.TRF_SEQ" ).append("\n"); 
		query.append("AND B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND B.TRF_SEQ = C.TRF_SEQ" ).append("\n"); 
		query.append("AND B.TRF_GRP_SEQ = C.TRF_GRP_SEQ" ).append("\n"); 
		query.append("AND D.INTG_CD_VAL_CTNT = C.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("AND E.INTG_CD_VAL_CTNT = C.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("AND D.INTG_CD_ID = 'CD02053'" ).append("\n"); 
		query.append("AND E.INTG_CD_ID = 'CD01963'" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND A.CVRG_CONTI_CD = @[cvrg_conti_cd]" ).append("\n"); 
		query.append("AND A.CVRG_CNT_CD = NVL(@[cvrg_cnt_cd],' ')" ).append("\n"); 
		query.append("AND A.CVRG_RGN_CD = NVL(@[cvrg_rgn_cd],' ')" ).append("\n"); 
		query.append("AND A.CVRG_STE_CD = NVL(@[cvrg_ste_cd],' ')" ).append("\n"); 
		query.append("AND A.CVRG_LOC_CD = NVL(@[cvrg_loc_cd],' ')" ).append("\n"); 
		query.append("AND A.CVRG_YD_CD = NVL(@[cvrg_yd_cd],' ')" ).append("\n"); 
		query.append("AND A.ORG_DEST_CONTI_CD = @[org_dest_conti_cd]" ).append("\n"); 
		query.append("AND A.ORG_DEST_CNT_CD = NVL(@[org_dest_cnt_cd],' ')" ).append("\n"); 
		query.append("AND A.ORG_DEST_RGN_CD = NVL(@[org_dest_rgn_cd],' ')" ).append("\n"); 
		query.append("AND A.ORG_DEST_STE_CD = NVL(@[org_dest_ste_cd],' ')" ).append("\n"); 
		query.append("AND A.ORG_DEST_LOC_CD = NVL(@[org_dest_loc_cd],' ')" ).append("\n"); 
		query.append("#if (${ui_code} == '1001')" ).append("\n"); 
		query.append("AND A.SUTH_CHN_USE_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${ui_code} == '4014')" ).append("\n"); 
		query.append("AND A.SUTH_CHN_USE_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_cntr_tp_cd} != '')" ).append("\n"); 
		query.append("AND C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${all_flg} == '')" ).append("\n"); 
		query.append("AND B.EXP_DT IS NULL" ).append("\n"); 
		query.append("AND C.TRF_GRP_SEQ = (SELECT MAX(TRF_GRP_SEQ) FROM DMT_TRF_CMB" ).append("\n"); 
		query.append("WHERE C.SYS_AREA_GRP_ID = SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD = DMDT_TRF_CD" ).append("\n"); 
		query.append("AND C.TRF_SEQ = TRF_SEQ" ).append("\n"); 
		query.append("AND C.DMDT_CNTR_TP_CD = DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("AND C.DMDT_CGO_TP_CD = DMDT_CGO_TP_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.SYS_AREA_GRP_ID = @[svr_id]" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND B.TRF_SEQ = @[trf_seq]" ).append("\n"); 
		query.append("AND B.TRF_GRP_SEQ = @[trf_grp_seq]" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("ORDER BY TRF_GRP_SEQ" ).append("\n"); 

	}
}