/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ConsultationSlipRequestMgtDBDAOAutoRevVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsultationSlipRequestMgtDBDAOAutoRevVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ConsultationSlipRequestMgtDBDAOAutoRevVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration").append("\n"); 
		query.append("FileName : ConsultationSlipRequestMgtDBDAOAutoRevVVDListRSQL").append("\n"); 
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
		query.append("SELECT    	D.VSL_CD" ).append("\n"); 
		query.append("     	, 	D.SKD_VOY_NO" ).append("\n"); 
		query.append("     	, 	D.SKD_DIR_CD" ).append("\n"); 
		query.append("     	, 	R.RLANE_DIR_CD 		AS REV_DIR_CD" ).append("\n"); 
		query.append("     	, 	D.INV_RGST_NO" ).append("\n"); 
		query.append("     	, 	D.INV_RGST_SEQ  " ).append("\n"); 
		query.append("FROM   		AP_PAY_INV 			H" ).append("\n"); 
		query.append("     	, 	AP_PAY_INV_DTL 		D" ).append("\n"); 
		query.append("     	, 	AR_MST_REV_VVD 		R" ).append("\n"); 
		query.append("     	, 	PSO_CHARGE     		PH" ).append("\n"); 
		query.append("     	, 	PSO_CHG_DTL    		PD" ).append("\n"); 
		query.append("WHERE  		1 = 1" ).append("\n"); 
		query.append("AND    		PH.ISS_CTY_CD  		= PD.ISS_CTY_CD" ).append("\n"); 
		query.append("AND    		PH.SO_SEQ      		= PD.SO_SEQ" ).append("\n"); 
		query.append("AND    		PH.INV_RGST_NO 		= H.INV_RGST_NO" ).append("\n"); 
		query.append("AND    		PD.LGS_COST_CD 		= D.LGS_COST_CD" ).append("\n"); 
		query.append("AND    		H.INV_SUB_SYS_CD 	= 'PSO'" ).append("\n"); 
		query.append("AND 		H.INV_RGST_NO    	= D.INV_RGST_NO" ).append("\n"); 
		query.append("AND 		D.DELT_FLG       	= 'N'" ).append("\n"); 
		query.append("AND 		H.INV_NO         	= @[inv_no]" ).append("\n"); 
		query.append("AND 		H.VNDR_SEQ       	= @[vndr_seq]" ).append("\n"); 
		query.append("AND 		D.VSL_CD         	= R.VSL_CD" ).append("\n"); 
		query.append("AND 		D.SKD_VOY_NO     	= R.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 		D.SKD_DIR_CD     	= R.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 		D.SLAN_CD        	= R.SLAN_CD  " ).append("\n"); 
		query.append("AND 		D.INV_RGST_SEQ   	= PD.SO_DTL_SEQ" ).append("\n"); 
		query.append("AND 		R.DELT_FLG       	= 'N'" ).append("\n"); 
		query.append("AND 		R.RLANE_CD 			= NVL( (" ).append("\n"); 
		query.append("                    					SELECT 	MAX(L.RLANE_CD)" ).append("\n"); 
		query.append("                    					FROM   	AR_MST_REV_VVD 	L" ).append("\n"); 
		query.append("                    					WHERE  	L.VSL_CD     	= D.VSL_CD" ).append("\n"); 
		query.append("                    					AND    	L.SKD_VOY_NO 	= D.SKD_VOY_NO" ).append("\n"); 
		query.append("                    					AND    	L.SKD_DIR_CD 	= D.SKD_DIR_CD" ).append("\n"); 
		query.append("                    					AND    	L.RLANE_CD   	=  NVL(PSO_GET_REV_LANE_FNC(D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, SUBSTR (D.YD_CD, 1, 5), PD.IO_BND_CD), L.RLANE_CD)" ).append("\n"); 
		query.append("                    					), R.RLANE_CD)	" ).append("\n"); 
		query.append("AND 		R.REV_YRMON 		= NVL( (" ).append("\n"); 
		query.append("                    					SELECT   MAX(L.REV_YRMON)" ).append("\n"); 
		query.append("                    					FROM   	AR_MST_REV_VVD 	L" ).append("\n"); 
		query.append("                    					WHERE   L.VSL_CD 		= D.VSL_CD" ).append("\n"); 
		query.append("                    					AND 	L.SKD_VOY_NO 	= D.SKD_VOY_NO" ).append("\n"); 
		query.append("                    					AND 	L.SKD_DIR_CD 	= D.SKD_DIR_CD" ).append("\n"); 
		query.append("                    					AND 	L.RLANE_CD 		=  NVL(PSO_GET_REV_LANE_FNC(D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, SUBSTR (D.YD_CD, 1, 5), PD.IO_BND_CD), L.RLANE_CD)" ).append("\n"); 
		query.append("                    					), SUBSTR(H.GL_DT,1,6))     " ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'CNTC' VSL_CD" ).append("\n"); 
		query.append("     , DECODE(NVL(" ).append("\n"); 
		query.append("                  ( SELECT" ).append("\n"); 
		query.append("                          CASE" ).append("\n"); 
		query.append("                                  WHEN SUM(DECODE(A.CLZ_STS_CD" ).append("\n"); 
		query.append("                                                ,'O',1,0)) > 0" ).append("\n"); 
		query.append("                                  THEN 'O'" ).append("\n"); 
		query.append("                                  ELSE 'C'" ).append("\n"); 
		query.append("                          END STS" ).append("\n"); 
		query.append("                  FROM    AP_PERIOD A" ).append("\n"); 
		query.append("                  WHERE   A.SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("                      AND A.EFF_YRMON  = TO_CHAR(H.INV_ISS_DT,'YYYYMM')" ).append("\n"); 
		query.append("                      AND A.OFC_CD    IN ( H.COST_OFC_CD" ).append("\n"); 
		query.append("                                         , ( SELECT M.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                           FROM    MDM_ORGANIZATION M" ).append("\n"); 
		query.append("                                           WHERE   M.OFC_CD = H.COST_OFC_CD" ).append("\n"); 
		query.append("                                           ))" ).append("\n"); 
		query.append("                      AND A.AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("                  ),'C')" ).append("\n"); 
		query.append("            , 'O', TO_CHAR(H.INV_ISS_DT,'YYMM')" ).append("\n"); 
		query.append("            , 'C', ( SELECT SUBSTR(MIN(N.EFF_YRMON),3,4)" ).append("\n"); 
		query.append("              FROM    AP_PERIOD N" ).append("\n"); 
		query.append("              WHERE   N.SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("                  AND N.EFF_YRMON >= TO_CHAR(H.INV_ISS_DT,'YYYYMM')" ).append("\n"); 
		query.append("                  AND N.OFC_CD    IN ( H.COST_OFC_CD" ).append("\n"); 
		query.append("                                     , ( SELECT M.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                       FROM    MDM_ORGANIZATION M" ).append("\n"); 
		query.append("                                       WHERE   M.OFC_CD = H.COST_OFC_CD" ).append("\n"); 
		query.append("                                       ))" ).append("\n"); 
		query.append("                  AND N.AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("                  AND N.CLZ_STS_CD   = 'O'" ).append("\n"); 
		query.append("              )) SKD_VOY_NO" ).append("\n"); 
		query.append("     , 'M' SKD_DIR_CD" ).append("\n"); 
		query.append("     , 'M' REV_DIR_CD" ).append("\n"); 
		query.append("     , D.INV_RGST_NO" ).append("\n"); 
		query.append("     , D.INV_RGST_SEQ" ).append("\n"); 
		query.append("FROM   AP_PAY_INV H" ).append("\n"); 
		query.append("     , AP_PAY_INV_DTL D" ).append("\n"); 
		query.append("WHERE  H.INV_NO          = @[inv_no]   --:inv_no" ).append("\n"); 
		query.append("   AND H.VNDR_SEQ        = @[vndr_seq] --:vndr_seq" ).append("\n"); 
		query.append("   AND H.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("   AND H.INV_SUB_SYS_CD <> 'PSO'" ).append("\n"); 
		query.append("   AND H.INV_RGST_NO     = D.INV_RGST_NO" ).append("\n"); 
		query.append("   AND D.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("   AND D.VSL_CD          <> 'CNTC'" ).append("\n"); 

	}
}