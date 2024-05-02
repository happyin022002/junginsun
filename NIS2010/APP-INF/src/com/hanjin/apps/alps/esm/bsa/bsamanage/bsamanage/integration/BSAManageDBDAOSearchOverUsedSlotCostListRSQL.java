/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOSearchOverUsedSlotCostListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.02 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchOverUsedSlotCostListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BSA_0162 (Inquire/Edit Over Used Slot Price) 조회 쿼리
	  * </pre>
	  */
	public BSAManageDBDAOSearchOverUsedSlotCostListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coblane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtsdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobdir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchOverUsedSlotCostListRSQL").append("\n"); 
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
		query.append("RANK() OVER (ORDER BY A1.TRD_CD,A1.RLANE_CD,A1.DIR_CD,A1.FM_PORT_CD, A1.TO_PORT_CD) AS GRP" ).append("\n"); 
		query.append(",DENSE_RANK() OVER (PARTITION BY A1.TRD_CD,A1.RLANE_CD,A1.DIR_CD,A1.FM_PORT_CD, A1.TO_PORT_CD" ).append("\n"); 
		query.append("ORDER BY A1.TRD_CD,A1.RLANE_CD,A1.DIR_CD,A1.FM_PORT_CD, A1.TO_PORT_CD,A1.BSA_SLT_PRC_FM_DT) AS SEQ" ).append("\n"); 
		query.append(",A1.TRD_CD" ).append("\n"); 
		query.append(",A1.RLANE_CD" ).append("\n"); 
		query.append(",A1.DIR_CD" ).append("\n"); 
		query.append(",A1.VVD_CD" ).append("\n"); 
		query.append(",A1.BSA_SLT_PRC_FM_DT" ).append("\n"); 
		query.append(",A1.BSA_SLT_PRC_TO_DT" ).append("\n"); 
		query.append(",A1.FM_PORT_CD, A1.TO_PORT_CD" ).append("\n"); 
		query.append(",A1.OVR_USD_SLT_PRC_SEQ" ).append("\n"); 
		query.append(",SUM(CASE WHEN A2.BSA_OP_JB_CD = '001' AND A2.CRR_CD ='XXX' THEN A2.UC_AMT ELSE 0 END) AS BZC_CHTR_UC_AMT" ).append("\n"); 
		query.append(",SUM(CASE WHEN A2.BSA_OP_JB_CD = '003' AND A2.CRR_CD ='XXX' THEN A2.UC_AMT ELSE 0 END) AS CHTR_UC_AMT" ).append("\n"); 
		query.append(",SUM(CASE WHEN A2.BSA_OP_JB_CD = '005' AND A2.CRR_CD ='XXX' THEN A2.UC_AMT ELSE 0 END) AS ADD_CHTR_UC_AMT" ).append("\n"); 
		query.append("#set($count = 0)" ).append("\n"); 
		query.append("#foreach( ${keys} in ${keyList})" ).append("\n"); 
		query.append(",SUM(CASE WHEN A2.BSA_OP_JB_CD ='${keys.bsaOpJbCd}' AND A2.CRR_CD ='${keys.crrCd}'" ).append("\n"); 
		query.append("THEN A2.UC_AMT ELSE 0 END) AS UC_AMT$count" ).append("\n"); 
		query.append("#set($count = $count + 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BSA_OVR_USD_MST A1" ).append("\n"); 
		query.append(",BSA_OVR_USD_SLT_PRC A2" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A1.OVR_USD_SLT_PRC_SEQ = A2.OVR_USD_SLT_PRC_SEQ(+)" ).append("\n"); 
		query.append("AND A1.BSA_SLT_PRC_TO_DT   >= @[txtsdate]" ).append("\n"); 
		query.append("AND A1.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("#if (${cobtrade} !='')" ).append("\n"); 
		query.append("AND A1.TRD_CD    = @[cobtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${coblane}!='')" ).append("\n"); 
		query.append("AND A1.RLANE_CD  = @[coblane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cobdir}!='')" ).append("\n"); 
		query.append("AND A1.DIR_CD    = @[cobdir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A1.TRD_CD," ).append("\n"); 
		query.append("A1.RLANE_CD," ).append("\n"); 
		query.append("A1.DIR_CD," ).append("\n"); 
		query.append("A1.VVD_CD," ).append("\n"); 
		query.append("A1.BSA_SLT_PRC_FM_DT," ).append("\n"); 
		query.append("A1.BSA_SLT_PRC_TO_DT," ).append("\n"); 
		query.append("A1.FM_PORT_CD," ).append("\n"); 
		query.append("A1.TO_PORT_CD," ).append("\n"); 
		query.append("A1.OVR_USD_SLT_PRC_SEQ" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("A1.TRD_CD," ).append("\n"); 
		query.append("A1.RLANE_CD," ).append("\n"); 
		query.append("A1.DIR_CD," ).append("\n"); 
		query.append("A1.BSA_SLT_PRC_FM_DT," ).append("\n"); 
		query.append("A1.BSA_SLT_PRC_TO_DT," ).append("\n"); 
		query.append("A1.FM_PORT_CD," ).append("\n"); 
		query.append("A1.TO_PORT_CD," ).append("\n"); 
		query.append("A1.OVR_USD_SLT_PRC_SEQ" ).append("\n"); 

	}
}