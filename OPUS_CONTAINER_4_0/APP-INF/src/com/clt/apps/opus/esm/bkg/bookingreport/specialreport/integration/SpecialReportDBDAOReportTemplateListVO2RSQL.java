/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialReportDBDAOReportTemplateListVO2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.02 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.specialreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialReportDBDAOReportTemplateListVO2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * check user
	  * </pre>
	  */
	public SpecialReportDBDAOReportTemplateListVO2RSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rpt_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("USR_ID" ).append("\n"); 
		query.append("FROM BKG_RPT_SET" ).append("\n"); 
		query.append("WHERE	USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND	BKG_RPT_KND_CD = @[bkg_rpt_knd_cd]" ).append("\n"); 
		query.append("AND	RPT_ID = @[rpt_id]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.specialreport.integration").append("\n"); 
		query.append("FileName : SpecialReportDBDAOReportTemplateListVO2RSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}