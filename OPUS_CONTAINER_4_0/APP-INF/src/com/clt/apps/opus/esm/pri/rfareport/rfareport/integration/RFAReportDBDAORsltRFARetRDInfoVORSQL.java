/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAReportDBDAORsltRFARetRDInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.09.16 변영주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfareport.rfareport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Byeon Young Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAReportDBDAORsltRFARetRDInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAReportDBDAORsltRFARetRDInfoVORSQL
	  * </pre>
	  */
	public RFAReportDBDAORsltRFARetRDInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfareport.rfareport.integration").append("\n"); 
		query.append("FileName : RFAReportDBDAORsltRFARetRDInfoVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("HDR.RFA_NO                  ," ).append("\n"); 
		query.append("MN.PROP_NO					," ).append("\n"); 
		query.append("MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_RP_HDR HDR          ," ).append("\n"); 
		query.append("PRI_RP_MN MN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("MN.PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND MN.PROP_NO  = HDR.PROP_NO" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("HDR.RFA_NO," ).append("\n"); 
		query.append("MN.PROP_NO" ).append("\n"); 

	}
}