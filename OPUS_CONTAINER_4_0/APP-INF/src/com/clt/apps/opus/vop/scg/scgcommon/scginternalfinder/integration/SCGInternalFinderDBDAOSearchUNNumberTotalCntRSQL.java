/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCGInternalFinderDBDAOSearchUNNumberTotalCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGInternalFinderDBDAOSearchUNNumberTotalCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public SCGInternalFinderDBDAOSearchUNNumberTotalCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_amdt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.integration").append("\n"); 
		query.append("FileName : SCGInternalFinderDBDAOSearchUNNumberTotalCntRSQL").append("\n"); 
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
		query.append("SELECT    " ).append("\n"); 
		query.append("              COUNT(*) TOTAL_CNT" ).append("\n"); 
		query.append("        FROM  SCG_IMDG_UN_NO A" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("        #if (${imdg_un_no} != '') " ).append("\n"); 
		query.append("              AND   A.IMDG_UN_NO       = @[imdg_un_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${imdg_un_no_seq} != '')" ).append("\n"); 
		query.append("              AND   A.IMDG_UN_NO_SEQ   = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${imdg_amdt_no} != '') " ).append("\n"); 
		query.append("              AND IMDG_AMDT_NO = @[imdg_amdt_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 

	}
}