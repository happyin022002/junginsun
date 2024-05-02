/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdBSAVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.12.11 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdBSAVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LoadFactorByTradeLaneVvdBSAVO
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdBSAVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromregion",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdBSAVORSQL").append("\n"); 
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
		query.append("#if (${gubun} == '1')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM(M.BSA_SLOT)                         bsaspace ," ).append("\n"); 
		query.append("SUM(M.BSA_WGT)                          bsaweight  --," ).append("\n"); 
		query.append("--        SUM(M.BSA_WGT)  /   SUM(M.BSA_SLOT)     BSA_RATE" ).append("\n"); 
		query.append("FROM    RDR_HEADER      H," ).append("\n"); 
		query.append("RDR_ALLOCATION  M" ).append("\n"); 
		query.append("WHERE   H.VSL_CD    =   SUBSTR(@[vvd],1,4)  --  /* SUBSTR(:vvd,1,4) */" ).append("\n"); 
		query.append("AND     H.VOY_NO    =   SUBSTR(@[vvd],5,4)  --  /* SUBSTR(:vvd,5,4) */" ).append("\n"); 
		query.append("AND     H.DIR_CD    =   SUBSTR(@[vvd],9,1)     --  /* SUBSTR(:vvd,9,4) */" ).append("\n"); 
		query.append("AND     H.REGION    =   @[fromregion]    --  /* from_region		*/" ).append("\n"); 
		query.append("AND     H.VSL_CD    =   M.VSL_CD" ).append("\n"); 
		query.append("AND     H.VOY_NO    =   M.VOY_NO" ).append("\n"); 
		query.append("AND     H.DIR_CD    =   M.DIR_CD" ).append("\n"); 
		query.append("AND     H.REGION    =   M.REGION" ).append("\n"); 
		query.append("AND     M.OPR_CD    =   @[company]" ).append("\n"); 
		query.append("GROUP BY 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT	/*+ INDEX( BSA_VVD_OTR_CRR XPKBSA_VVD_OTR_CRR ) */" ).append("\n"); 
		query.append("NVL(MAX(DECODE(BSA_OP_JB_CD,'007',CRR_BSA_CAPA,0)),0) bsaspace," ).append("\n"); 
		query.append("NVL(MAX(DECODE(BSA_OP_JB_CD,'009',CRR_BSA_CAPA,0)),0) bsaweight" ).append("\n"); 
		query.append("FROM	BSA_VVD_OTR_CRR" ).append("\n"); 
		query.append("WHERE	TRD_CD					= @[trade]" ).append("\n"); 
		query.append("AND  	RLANE_CD 				LIKE @[lane]||'%'" ).append("\n"); 
		query.append("AND		VSL_CD					= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND		SKD_VOY_NO				= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND		SKD_DIR_CD				= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND     CRR_CD					= @[company]" ).append("\n"); 
		query.append("HAVING	NVL(MAX(DECODE(BSA_OP_JB_CD,'007',CRR_BSA_CAPA,0)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(BSA_OP_JB_CD,'009',CRR_BSA_CAPA,0)),0) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}