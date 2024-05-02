/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOGetEvntDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.06
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.04.06 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetEvntDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetEvntDt
	  * </pre>
	  */
	public Edi315SendDBDAOGetEvntDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sts",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetEvntDtRSQL").append("\n"); 
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
		query.append("to_char(estm_dt,'yyyymmddhh24miss')estm_dt" ).append("\n"); 
		query.append(", to_char(act_dt ,'yyyymmddhh24miss')act_dt" ).append("\n"); 
		query.append(", to_char(GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(nod_cd,1,5), estm_dt, 'GMT'),'yyyymmddhh24miss') as gmt_estm_dt" ).append("\n"); 
		query.append(", to_char(GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(nod_cd,1,5),  act_dt, 'GMT'),'yyyymmddhh24miss') as gmt_act_dt" ).append("\n"); 
		query.append("from sce_cop_dtl" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and cop_no = @[cop_no]" ).append("\n"); 
		query.append("and stnd_edi_sts_cd = @[edi_sts]" ).append("\n"); 

	}
}