/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOCarrierCdRSQL.java
*@FileTitle : ChangeOfDestinationMgtDBDAOCODEmailSendRSQL
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.29
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2010.07.29 원종규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOCarrierCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 VVD의 Carrier Code 조회
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOCarrierCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",HNIR0119E";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOCarrierCdRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN VS.ACT_CRR_CD IS NOT NULL AND LENGTH(LTRIM(RTRIM(VS.ACT_CRR_CD))) > 0 THEN" ).append("\n"); 
		query.append("VS.ACT_CRR_CD" ).append("\n"); 
		query.append("WHEN  VS.ACT_CRR_CD IS NULL OR LENGTH(LTRIM(RTRIM(VS.ACT_CRR_CD))) = 0 THEN" ).append("\n"); 
		query.append("(SELECT VC.CRR_CD" ).append("\n"); 
		query.append("FROM   MDM_VSL_CNTR VC" ).append("\n"); 
		query.append("WHERE  VC.VSL_CD = VS.VSL_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE  ''" ).append("\n"); 
		query.append("END  CARRIER_CD" ).append("\n"); 
		query.append("FROM      VSK_VSL_SKD    VS" ).append("\n"); 
		query.append("WHERE     1=1" ).append("\n"); 
		query.append("#if(${vvd} !='')" ).append("\n"); 
		query.append("AND		  VS.VSL_CD      = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("AND       VS.SKD_VOY_NO  = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("AND       VS.SKD_DIR_CD  = substr(@[vvd],9)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}