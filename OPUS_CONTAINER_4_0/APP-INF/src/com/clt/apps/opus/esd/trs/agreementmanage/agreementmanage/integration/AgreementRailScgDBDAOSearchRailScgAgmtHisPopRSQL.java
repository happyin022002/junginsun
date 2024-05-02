/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementRailScgDBDAOSearchRailScgAgmtHisPopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.05.25 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRailScgDBDAOSearchRailScgAgmtHisPopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US RAIL Surcharge 화면의 US RAIL Agreement Surcharge History Popup 조회 SQL
	  * </pre>
	  */
	public AgreementRailScgDBDAOSearchRailScgAgmtHisPopRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmNodCdPop",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toNodCdPop",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmtOfcPop",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndrSeqPop",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmtRoutAllFlgPop",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmtSeqPop",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspRailScgCdPop",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgoTpCdPop",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementRailScgDBDAOSearchRailScgAgmtHisPopRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("RANK() OVER(PARTITION BY A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ, A.VNDR_SEQ, A.TRSP_RAIL_SCG_CD," ).append("\n"); 
		query.append("A.AGMT_ROUT_ALL_FLG, A.FM_NOD_CD, A.TO_NOD_CD, A.CGO_TP_CD ORDER BY A.LOCL_CRE_DT ASC) AS SEQ," ).append("\n"); 
		query.append("A.TRSP_AGMT_OFC_CTY_CD||A.TRSP_AGMT_SEQ AS AGMT_NO," ).append("\n"); 
		query.append("A.VNDR_SEQ AS VNDR_SEQ," ).append("\n"); 
		query.append("B.VNDR_LGL_ENG_NM AS VNDR_NM," ).append("\n"); 
		query.append("A.TRSP_RAIL_SCG_CD AS TRSP_RAIL_SCG_CD," ).append("\n"); 
		query.append("A.AGMT_ROUT_ALL_FLG AS AGMT_ROUT_ALL_FLG," ).append("\n"); 
		query.append("DECODE(A.FM_NOD_CD, '00', '', A.FM_NOD_CD) AS FM_NOD_CD," ).append("\n"); 
		query.append("DECODE(A.TO_NOD_CD, '00', '', A.TO_NOD_CD) AS TO_NOD_CD," ).append("\n"); 
		query.append("A.CGO_TP_CD AS CGO_TP_CD," ).append("\n"); 
		query.append("A.TRSP_RAIL_RTO AS TRSP_RAIL_RTO," ).append("\n"); 
		query.append("TO_CHAR(A.EFF_FM_DT, 'YYYYMMDD') AS EFF_FM_DT," ).append("\n"); 
		query.append("TO_CHAR(A.EFF_TO_DT, 'YYYYMMDD') AS EFF_TO_DT," ).append("\n"); 
		query.append("A.RAIL_RTO_NO AS RAIL_RTO_NO," ).append("\n"); 
		query.append("A.LBS_OVR_WGT AS LBS_OVR_WGT," ).append("\n"); 
		query.append("A.CURR_CD AS CURR_CD," ).append("\n"); 
		query.append("A.FX_SCG_ALL_RT AS FX_SCG_ALL_RT," ).append("\n"); 
		query.append("A.FX_SCG_20FT_RT AS FX_SCG_20FT_RT," ).append("\n"); 
		query.append("A.FX_SCG_40FT_RT AS FX_SCG_40FT_RT," ).append("\n"); 
		query.append("A.FX_SCG_45FT_RT AS FX_SCG_45FT_RT," ).append("\n"); 
		query.append("A.FUEL_SCG_APLY_FLG AS FUEL_SCG_APLY_FLG," ).append("\n"); 
		query.append("A.DELT_FLG AS DELT_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_AGMT_RAIL_SCG_RT_HIS A," ).append("\n"); 
		query.append("MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND	  A.TRSP_AGMT_OFC_CTY_CD = @[agmtOfcPop]" ).append("\n"); 
		query.append("AND	  A.TRSP_AGMT_SEQ = @[agmtSeqPop]" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ = @[vndrSeqPop]" ).append("\n"); 
		query.append("AND	  A.TRSP_RAIL_SCG_CD = @[trspRailScgCdPop]" ).append("\n"); 
		query.append("AND	  A.AGMT_ROUT_ALL_FLG = @[agmtRoutAllFlgPop]" ).append("\n"); 
		query.append("AND	  A.FM_NOD_CD = @[fmNodCdPop]" ).append("\n"); 
		query.append("AND	  A.TO_NOD_CD = @[toNodCdPop]" ).append("\n"); 
		query.append("AND	  A.CGO_TP_CD = @[cgoTpCdPop]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("A.TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("A.TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.TRSP_RAIL_SCG_CD," ).append("\n"); 
		query.append("A.AGMT_ROUT_ALL_FLG," ).append("\n"); 
		query.append("A.FM_NOD_CD," ).append("\n"); 
		query.append("A.TO_NOD_CD," ).append("\n"); 
		query.append("A.CGO_TP_CD," ).append("\n"); 
		query.append("SEQ DESC" ).append("\n"); 

	}
}