/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EDISetupDBDAOAddEdiCgoStndStsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.01.28 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edisetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EDISetupDBDAOAddEdiCgoStndStsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddEdiCgoStndSts
	  * </pre>
	  */
	public EDISetupDBDAOAddEdiCgoStndStsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status_std_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("origin_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edisetup.integration").append("\n"); 
		query.append("FileName : EDISetupDBDAOAddEdiCgoStndStsCSQL").append("\n"); 
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
		query.append("insert into edi_cgo_stnd_sts" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("EDI_STND_STS_CD" ).append("\n"); 
		query.append(",CO_DIV_CD" ).append("\n"); 
		query.append(",EDI_STS_SEQ" ).append("\n"); 
		query.append(",EDI_STS_DESC" ).append("\n"); 
		query.append(",EDI_ORG_TP_CD" ).append("\n"); 
		query.append(",EDI_DEST_TP_CD" ).append("\n"); 
		query.append(",EAI_EVNT_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("values (" ).append("\n"); 
		query.append("@[status_std_cd]," ).append("\n"); 
		query.append("@[company_cd]," ).append("\n"); 
		query.append("@[status_seq]," ).append("\n"); 
		query.append("@[status_desc]," ).append("\n"); 
		query.append("@[origin_cd]," ).append("\n"); 
		query.append("@[dest_cd]," ).append("\n"); 
		query.append("to_date(@[eai_date],'yyyy/mm/dd hh24:mi:ss')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}