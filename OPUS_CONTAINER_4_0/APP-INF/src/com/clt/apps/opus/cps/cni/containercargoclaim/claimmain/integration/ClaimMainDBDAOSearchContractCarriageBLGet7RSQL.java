/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOSearchContractCarriageBLGet7RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.03.08 박제성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchContractCarriageBLGet7RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchContractCarriageBLGet7
	  * </pre>
	  */
	public ClaimMainDBDAOSearchContractCarriageBLGet7RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration ").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchContractCarriageBLGet7RSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("           NVL(DECODE(VSL_SEQ, 1, VSL_CD||SKD_VOY_NO||SKD_DIR_CD), '') AS N1ST_PRE_REF_VVD_NO " ).append("\n"); 
		query.append(",          NVL(DECODE(VSL_SEQ, 2, VSL_CD||SKD_VOY_NO||SKD_DIR_CD), '') AS N2ND_PRE_REF_VVD_NO" ).append("\n"); 
		query.append(",          NVL(DECODE(VSL_SEQ, 3, VSL_CD||SKD_VOY_NO||SKD_DIR_CD), '') AS N3RD_PRE_REF_VVD_NO" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("WHERE BKG_NO =   @[bkg_no]" ).append("\n"); 
		query.append("   AND VSL_PRE_PST_CD = 'S'" ).append("\n"); 

	}
}