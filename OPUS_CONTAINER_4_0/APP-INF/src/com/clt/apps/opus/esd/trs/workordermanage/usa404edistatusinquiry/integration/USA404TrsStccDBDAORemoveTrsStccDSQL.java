/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : USA404TrsStccDBDAORemoveTrsStccDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.04.26 이준근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404TrsStccDBDAORemoveTrsStccDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveTrsStcc
	  * </pre>
	  */
	public USA404TrsStccDBDAORemoveTrsStccDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stcc_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration ").append("\n"); 
		query.append("FileName : USA404TrsStccDBDAORemoveTrsStccDSQL").append("\n"); 
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
		query.append("DELETE TRS_STCC" ).append("\n"); 
		query.append(" WHERE STCC_CD = @[stcc_cd]" ).append("\n"); 
		query.append("   AND STCC_SEQ = @[stcc_seq]" ).append("\n"); 

	}
}