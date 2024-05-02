/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SettlementProcessDBDAOStlTgtDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.05.24 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOStlTgtDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement Target 삭제
	  * </pre>
	  */
	public SettlementProcessDBDAOStlTgtDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOStlTgtDSQL").append("\n"); 
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
		query.append("DELETE FROM JOO_STL_TGT J" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND J.REV_YRMON		    = @[rev_yrmon]		      " ).append("\n"); 
		query.append("AND J.REV_YRMON_SEQ     = @[rev_yrmon_seq]" ).append("\n"); 
		query.append("#if (${rev_seq} != '') " ).append("\n"); 
		query.append("AND J.REV_SEQ 			= @[rev_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND J.REV_SHW_FLG IN ('A','C') " ).append("\n"); 

	}
}