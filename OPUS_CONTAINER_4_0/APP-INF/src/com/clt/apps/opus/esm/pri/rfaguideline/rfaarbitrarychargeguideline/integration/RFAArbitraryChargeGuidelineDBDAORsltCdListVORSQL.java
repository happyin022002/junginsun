/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAArbitraryChargeGuidelineDBDAORsltCdListVORSQL.java
*@FileTitle : RFA Guideline Creation - Arbitrary[Load Excel]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.29 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAArbitraryChargeGuidelineDBDAORsltCdListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 공통코드 조회 체크
	  * </pre>
	  */
	public RFAArbitraryChargeGuidelineDBDAORsltCdListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.integration ").append("\n"); 
		query.append("FileName : RFAArbitraryChargeGuidelineDBDAORsltCdListVORSQL").append("\n"); 
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
		query.append("#if (${code_tp} == 'LOC')" ).append("\n"); 
		query.append("SELECT LOC_CD CD" ).append("\n"); 
		query.append(", LOC_NM NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = @[cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${code_tp} == 'GRP')" ).append("\n"); 
		query.append("SELECT PRC_GRP_LOC_CD CD" ).append("\n"); 
		query.append(", PRC_GRP_LOC_DESC NM" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_LOC" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD 		= @[etc1]" ).append("\n"); 
		query.append("AND GLINE_SEQ 		= @[etc2]" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD 	= @[cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}