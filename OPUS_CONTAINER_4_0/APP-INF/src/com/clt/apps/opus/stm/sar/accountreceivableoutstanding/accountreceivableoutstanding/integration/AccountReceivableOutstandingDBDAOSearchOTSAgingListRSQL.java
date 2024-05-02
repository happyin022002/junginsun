/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOSearchOTSAgingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOSearchOTSAgingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * create list vo query
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOSearchOTSAgingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOSearchOTSAgingListRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("  '' CLT_OFC_CD" ).append("\n"); 
		query.append(", '' CUST_NUM" ).append("\n"); 
		query.append(", '' CUST_NM" ).append("\n"); 
		query.append(", '' RHQ_CD" ).append("\n"); 
		query.append(", '' as col01" ).append("\n"); 
		query.append(", '' as col02" ).append("\n"); 
		query.append(", '' as col03" ).append("\n"); 
		query.append(", '' as col04" ).append("\n"); 
		query.append(", '' as col05" ).append("\n"); 
		query.append(", '' as col06" ).append("\n"); 
		query.append(", '' as col07" ).append("\n"); 
		query.append(", '' as col08" ).append("\n"); 
		query.append(", '' as col09" ).append("\n"); 
		query.append(", '' as col10" ).append("\n"); 
		query.append(", '' as col11" ).append("\n"); 
		query.append(", '' as col12" ).append("\n"); 
		query.append(", '' as col13" ).append("\n"); 
		query.append(", '' as col14" ).append("\n"); 
		query.append(", '' as col15" ).append("\n"); 
		query.append(", '' as col16" ).append("\n"); 
		query.append(", '' as col17" ).append("\n"); 
		query.append(", '' as col18" ).append("\n"); 
		query.append(", '' as col19" ).append("\n"); 
		query.append(", '' as col20" ).append("\n"); 
		query.append(", '' as col21" ).append("\n"); 
		query.append(", '' as col22" ).append("\n"); 
		query.append(", '' as col23" ).append("\n"); 
		query.append(", '' as col24" ).append("\n"); 
		query.append(", '' as col25" ).append("\n"); 
		query.append(", '' as col26" ).append("\n"); 
		query.append(", '' as col27" ).append("\n"); 
		query.append(", '' as col28" ).append("\n"); 
		query.append(", '' as col29" ).append("\n"); 
		query.append(", '' as col30" ).append("\n"); 
		query.append(", '' as col31" ).append("\n"); 
		query.append(", '' as col32" ).append("\n"); 
		query.append(", '' as col33" ).append("\n"); 
		query.append(", '' as col34" ).append("\n"); 
		query.append(", '' as col35" ).append("\n"); 
		query.append(", '' as col36" ).append("\n"); 
		query.append(", '' as col37" ).append("\n"); 
		query.append(", '' as col38" ).append("\n"); 
		query.append(", '' as col39" ).append("\n"); 
		query.append(", '' as col40" ).append("\n"); 
		query.append(", '' as col41" ).append("\n"); 
		query.append(", '' as col42" ).append("\n"); 
		query.append(", '' as col43" ).append("\n"); 
		query.append(", '' as col44" ).append("\n"); 
		query.append(", '' as col45" ).append("\n"); 
		query.append(", '' as col46" ).append("\n"); 
		query.append(", '' as col47" ).append("\n"); 
		query.append(", '' as col48" ).append("\n"); 
		query.append(", '' as col49" ).append("\n"); 
		query.append(", '' as col50" ).append("\n"); 
		query.append(", '' as col51" ).append("\n"); 
		query.append(", '' as col52" ).append("\n"); 
		query.append(", '' as col53" ).append("\n"); 
		query.append(", '' as col54" ).append("\n"); 
		query.append(", '' as col55" ).append("\n"); 
		query.append(", '' as col56" ).append("\n"); 
		query.append(", '' as col57" ).append("\n"); 
		query.append(", '' as col58" ).append("\n"); 
		query.append(", '' as col59" ).append("\n"); 
		query.append(", '' as col60" ).append("\n"); 
		query.append(", '' as col61" ).append("\n"); 
		query.append(", '' as col62" ).append("\n"); 
		query.append(", '' as col63" ).append("\n"); 
		query.append(", '' as col64" ).append("\n"); 
		query.append(", '' as col65" ).append("\n"); 
		query.append(", '' as col66" ).append("\n"); 
		query.append(", '' as col67" ).append("\n"); 
		query.append(", '' as col68" ).append("\n"); 
		query.append(", '' as col69" ).append("\n"); 
		query.append(", '' as col70" ).append("\n"); 
		query.append(", '' as col71" ).append("\n"); 
		query.append(", '' as col72" ).append("\n"); 
		query.append(", '' as col73" ).append("\n"); 
		query.append(", '' as col74" ).append("\n"); 
		query.append(", '' as col75" ).append("\n"); 
		query.append(", '' as col76" ).append("\n"); 
		query.append(", '' as col77" ).append("\n"); 
		query.append(", '' as col78" ).append("\n"); 
		query.append(", '' as col79" ).append("\n"); 
		query.append(", '' as col80" ).append("\n"); 
		query.append(", '' as col81" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}