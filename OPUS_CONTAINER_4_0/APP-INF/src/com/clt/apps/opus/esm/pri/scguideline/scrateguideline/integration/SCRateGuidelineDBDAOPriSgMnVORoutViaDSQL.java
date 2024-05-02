/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateGuidelineDBDAOPriSgMnVORoutViaDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.05.14 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scrateguideline.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungsoo
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class SCRateGuidelineDBDAOPriSgMnVORoutViaDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GuidelineMain Delete
	  * </pre>
	  */
	public SCRateGuidelineDBDAOPriSgMnVORoutViaDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "2,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM pri_sg_rt_rout_via" ).append("\n"); 
		query.append("WHERE svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND gline_seq = @[gline_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scrateguideline.integration ").append("\n"); 
		query.append("FileName : SCRateGuidelineDBDAOPriSgMnVORoutViaDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}