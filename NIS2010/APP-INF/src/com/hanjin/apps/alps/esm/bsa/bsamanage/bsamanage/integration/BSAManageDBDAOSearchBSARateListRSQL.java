/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOSearchBSARateListRSQL.java
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

public class BSAManageDBDAOSearchBSARateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BSA_0172 화면의 조회 쿼리
	  * </pre>
	  */
	public BSAManageDBDAOSearchBSARateListRSQL(){
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
		params.put("rdotype",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : BSAManageDBDAOSearchBSARateListRSQL").append("\n"); 
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
		query.append("RANK() OVER (ORDER BY A.TRD_CD||A.RLANE_CD||A.DIR_CD||A.CNTR_TPSZ_CD) GRP," ).append("\n"); 
		query.append("MAX(A.BSA_SEQ) OVER(PARTITION BY A.TRD_CD||A.RLANE_CD||A.DIR_CD||A.CNTR_TPSZ_CD) MAXSEQ," ).append("\n"); 
		query.append("A.BSA_SEQ," ).append("\n"); 
		query.append("A.BSA_SEQ BSA_SEQ_ORG," ).append("\n"); 
		query.append("A.VVD_CD," ).append("\n"); 
		query.append("A.BSA_FM_DT," ).append("\n"); 
		query.append("A.BSA_TO_DT," ).append("\n"); 
		query.append("A.TRD_CD," ).append("\n"); 
		query.append("A.RLANE_CD," ).append("\n"); 
		query.append("A.DIR_CD," ).append("\n"); 
		query.append("A.VOP_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if (${rdotype}==\"D7\")" ).append("\n"); 
		query.append("#set($count = 0)" ).append("\n"); 
		query.append("#foreach( ${keys} in ${keyList})" ).append("\n"); 
		query.append(",MAX(DECODE(B.CRR_CD,'${keys}',B.HC_RT,0 ) ) 		AS HC_RT$count" ).append("\n"); 
		query.append(",MAX(DECODE(B.CRR_CD,'${keys}',B.HC_OVR_RT,0 ) ) 	AS HC_OVR_RT$count" ).append("\n"); 
		query.append(",MAX(DECODE(B.CRR_CD,'${keys}',B.RT_TP_FLG,'' ) )  AS RT_TP_FLG$count" ).append("\n"); 
		query.append("#set($count = $count + 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#set($count = 0)" ).append("\n"); 
		query.append("#foreach( ${keys} in ${keyList})" ).append("\n"); 
		query.append(",MAX(DECODE(B.CRR_CD,'${keys}',B.HC_OVR_RT,0 ) ) AS HC_OVR_RT$count" ).append("\n"); 
		query.append(",MAX(DECODE(B.CRR_CD,'${keys}',B.RT_TP_FLG,'' ) ) AS RT_TP_FLG$count" ).append("\n"); 
		query.append("#set($count = $count + 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BSA_HIGH_CUBIC_RT_MST     A" ).append("\n"); 
		query.append(",BSA_HIGH_CUBIC_RT_DTL B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD  = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND  A.CNTR_TPSZ_CD  = @[rdotype]" ).append("\n"); 
		query.append("AND  A.BSA_SEQ       = B.BSA_SEQ" ).append("\n"); 
		query.append("AND  A.BSA_TO_DT     >= @[txtsdate]" ).append("\n"); 
		query.append("AND  A.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("#if (${cobtrade} !='')" ).append("\n"); 
		query.append("AND  A.TRD_CD 		= @[cobtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${coblane}!='')" ).append("\n"); 
		query.append("AND  A.RLANE_CD 	= @[coblane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cobdir}!='')" ).append("\n"); 
		query.append("AND  A.DIR_CD 		= @[cobdir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.TRD_CD," ).append("\n"); 
		query.append("A.RLANE_CD," ).append("\n"); 
		query.append("A.DIR_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.BSA_SEQ," ).append("\n"); 
		query.append("A.VVD_CD," ).append("\n"); 
		query.append("A.BSA_FM_DT," ).append("\n"); 
		query.append("A.BSA_TO_DT," ).append("\n"); 
		query.append("A.VOP_CD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("A.BSA_SEQ," ).append("\n"); 
		query.append("A.VVD_CD," ).append("\n"); 
		query.append("A.BSA_FM_DT," ).append("\n"); 
		query.append("A.BSA_TO_DT," ).append("\n"); 
		query.append("A.TRD_CD," ).append("\n"); 
		query.append("A.RLANE_CD," ).append("\n"); 
		query.append("A.DIR_CD," ).append("\n"); 
		query.append("A.VOP_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD" ).append("\n"); 

	}
}