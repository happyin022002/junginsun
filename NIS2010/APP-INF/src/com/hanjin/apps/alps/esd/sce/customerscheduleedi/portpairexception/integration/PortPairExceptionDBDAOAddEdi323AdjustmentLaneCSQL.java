/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortPairExceptionDBDAOAddEdi323AdjustmentLaneCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAOAddEdi323AdjustmentLaneCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sce_323_adj_lane 테이블에 인서트함
	  * </pre>
	  */
	public PortPairExceptionDBDAOAddEdi323AdjustmentLaneCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cds",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_rgst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOAddEdi323AdjustmentLaneCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_323_ADJ_LANE" ).append("\n"); 
		query.append("	(	" ).append("\n"); 
		query.append("		 ADJ_RGST_DT" ).append("\n"); 
		query.append("		,ADJ_SEQ" ).append("\n"); 
		query.append("		,SLAN_CD" ).append("\n"); 
		query.append("		,DELT_FLG" ).append("\n"); 
		query.append("		,CRE_USR_ID" ).append("\n"); 
		query.append("		,CRE_DT" ).append("\n"); 
		query.append("		,UPD_USR_ID" ).append("\n"); 
		query.append("		,UPD_DT" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("SELECT	" ).append("\n"); 
		query.append("		 @[adj_rgst_dt]	" ).append("\n"); 
		query.append("		,@[adj_seq]		" ).append("\n"); 
		query.append("		,SPLIT_SLAN_CD" ).append("\n"); 
		query.append("		,'N'" ).append("\n"); 
		query.append("		,@[cre_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("		,@[upd_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("			SELECT" ).append("\n"); 
		query.append("					REGEXP_SUBSTR( SPLIT_SLAN_CD, '[^,]+', 1, LEVEL ) AS SPLIT_SLAN_CD" ).append("\n"); 
		query.append("			FROM	(" ).append("\n"); 
		query.append("						SELECT	@[slan_cds] AS SPLIT_SLAN_CD" ).append("\n"); 
		query.append("						FROM	DUAL" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			CONNECT BY " ).append("\n"); 
		query.append("					REGEXP_SUBSTR( SPLIT_SLAN_CD, '[^,]+', 1, LEVEL ) IS NOT NULL 				" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}