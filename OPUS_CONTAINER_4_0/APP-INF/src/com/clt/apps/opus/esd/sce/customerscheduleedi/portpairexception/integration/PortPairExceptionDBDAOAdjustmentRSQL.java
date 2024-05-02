/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairExceptionDBDAOAdjustmentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.04.13 함대성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAOAdjustmentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PortPairExceptionDBDAOAdjustmentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_conti",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_conti",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOAdjustmentRSQL").append("\n"); 
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
		query.append("SPR.ORG_LOC_CD POL_CD," ).append("\n"); 
		query.append("SPR.DEST_LOC_CD POD_CD," ).append("\n"); 
		query.append("val AS BLOCK_LANE," ).append("\n"); 
		query.append("ADJ.SLAN_CD," ).append("\n"); 
		query.append("ADJ.ADJ_SEQ," ).append("\n"); 
		query.append("ADJ.ETD_ADJ_DY," ).append("\n"); 
		query.append("ADJ.ETD_ADJ_HRMNT," ).append("\n"); 
		query.append("ADJ.DCT_ADJ_TP_NM," ).append("\n"); 
		query.append("DECODE(ADJ.DCT_ADJ_TP_NM, 'DAY', '1', '0') IS_DCT_ADJ_DY," ).append("\n"); 
		query.append("DECODE(ADJ.DCT_ADJ_TP_NM, 'ETB', '1', '0') IS_DCT_ADJ_ETB," ).append("\n"); 
		query.append("DECODE(ADJ.DCT_ADJ_TP_NM, 'ETD', '1', '0') IS_DCT_ADJ_ETD," ).append("\n"); 
		query.append("ADJ.DCT_ADJ_DY," ).append("\n"); 
		query.append("ADJ.DCT_ADJ_ETB_DYS," ).append("\n"); 
		query.append("ADJ.DCT_ADJ_ETD_DYS," ).append("\n"); 
		query.append("ADJ.DCT_ADJ_HRMNT," ).append("\n"); 
		query.append("ADJ.CCT_ADJ_TP_NM," ).append("\n"); 
		query.append("DECODE(ADJ.CCT_ADJ_TP_NM, 'DAY', '1', '0') IS_CCT_ADJ_DY," ).append("\n"); 
		query.append("DECODE(ADJ.CCT_ADJ_TP_NM, 'ETB', '1', '0') IS_CCT_ADJ_ETB," ).append("\n"); 
		query.append("DECODE(ADJ.CCT_ADJ_TP_NM, 'ETD', '1', '0') IS_CCT_ADJ_ETD," ).append("\n"); 
		query.append("ADJ.CCT_ADJ_DY," ).append("\n"); 
		query.append("ADJ.CCT_ADJ_ETB_DYS," ).append("\n"); 
		query.append("ADJ.CCT_ADJ_ETD_DYS," ).append("\n"); 
		query.append("ADJ.CCT_ADJ_HRMNT," ).append("\n"); 
		query.append("ADJ.CUST_TRD_PRNR_ID," ).append("\n"); 
		query.append("'' POL_CNT," ).append("\n"); 
		query.append("'' POD_CNT," ).append("\n"); 
		query.append("'' POL_CONTI," ).append("\n"); 
		query.append("'' POD_CONTI," ).append("\n"); 
		query.append("'' CRE_USR_ID," ).append("\n"); 
		query.append("'' CRE_DT," ).append("\n"); 
		query.append("'' UPD_USR_ID," ).append("\n"); 
		query.append("ADJ.UPD_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ORG_LOC_CD," ).append("\n"); 
		query.append("DEST_LOC_CD," ).append("\n"); 
		query.append("substr(xmlagg(xmlelement(a, DECODE(SLAN_CD, '', '', ',') || SLAN_CD)" ).append("\n"); 
		query.append("order by SLAN_CD).extract('//text()'), 2) VAL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT A.ORG_LOC_CD," ).append("\n"); 
		query.append("A.DEST_LOC_CD," ).append("\n"); 
		query.append("B.SLAN_CD" ).append("\n"); 
		query.append("FROM SCE_PORT_PAIR_DTL A," ).append("\n"); 
		query.append("SCE_CUST_EDI_BLCK B" ).append("\n"); 
		query.append("WHERE A.ROUT_RCV_DT = B.ROUT_RCV_DT(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = B.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_TRD_PRNR_ID = 'C1T0W'" ).append("\n"); 
		query.append("AND B.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY A.ORG_LOC_CD, A.DEST_LOC_CD) SPR," ).append("\n"); 
		query.append("SCE_CUST_EDI_ADJ ADJ," ).append("\n"); 
		query.append("MDM_LOCATION POL," ).append("\n"); 
		query.append("MDM_LOCATION POD" ).append("\n"); 
		query.append("WHERE SPR.ORG_LOC_CD = ADJ.POL_CD(+)" ).append("\n"); 
		query.append("AND SPR.DEST_LOC_CD = ADJ.POD_CD(+)" ).append("\n"); 
		query.append("AND ADJ.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND SPR.ORG_LOC_CD = POL.LOC_CD" ).append("\n"); 
		query.append("AND SPR.DEST_LOC_CD = POD.LOC_CD" ).append("\n"); 
		query.append("AND POL.LOC_CD = NVL(@[pol], POL.LOC_CD)" ).append("\n"); 
		query.append("AND POD.LOC_CD = NVL(@[pod], POD.LOC_CD)" ).append("\n"); 
		query.append("AND POL.CNT_CD = NVL(@[pol_cnt], POL.CNT_CD)" ).append("\n"); 
		query.append("AND POD.CNT_CD = NVL(@[pod_cnt], POD.CNT_CD)" ).append("\n"); 
		query.append("AND POL.CONTI_CD = NVL(@[pol_conti], POL.CONTI_CD)" ).append("\n"); 
		query.append("AND POD.CONTI_CD = NVL(@[pod_conti], POD.CONTI_CD)" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("AND ADJ.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY SPR.ORG_LOC_CD, SPR.DEST_LOC_CD, ADJ.SLAN_CD, ADJ.UPD_DT" ).append("\n"); 

	}
}