/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOAddSceEdiAmsIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOAddSceEdiAmsIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSceEdiAmsIf
	  * </pre>
	  */
	public Edi315SendDBDAOAddSceEdiAmsIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_yd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOAddSceEdiAmsIfCSQL").append("\n"); 
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
		query.append("insert into sce_edi_ams_if" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("EDI_RCV_DT" ).append("\n"); 
		query.append(",EDI_RCV_SEQ" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",EDI_STND_STS_CD" ).append("\n"); 
		query.append(",EVNT_YD_CD" ).append("\n"); 
		query.append(",EVNT_DT" ).append("\n"); 
		query.append(",EDI_IF_STS_CD" ).append("\n"); 
		query.append(",EVNT_SEQ" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("values" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("to_char(sysdate, 'yyyymmdd')" ).append("\n"); 
		query.append(",  SCE_EDI_AMS_IF_SEQ.nextval" ).append("\n"); 
		query.append(",  @[bl_no]" ).append("\n"); 
		query.append(",  @[edi_sts]" ).append("\n"); 
		query.append(",  @[event_yd]" ).append("\n"); 
		query.append(",  to_date(@[event_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(",  '00'" ).append("\n"); 
		query.append(",  '0'" ).append("\n"); 
		query.append(",  'ams'" ).append("\n"); 
		query.append(",  sysdate" ).append("\n"); 
		query.append(",  'AMS'" ).append("\n"); 
		query.append(",  sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}