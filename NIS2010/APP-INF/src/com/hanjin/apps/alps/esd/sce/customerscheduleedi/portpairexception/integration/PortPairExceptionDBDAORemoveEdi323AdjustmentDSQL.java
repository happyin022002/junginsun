/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortPairExceptionDBDAORemoveEdi323AdjustmentDSQL.java
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

public class PortPairExceptionDBDAORemoveEdi323AdjustmentDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sce_323_adj 테이블의 데이터를 삭제 처리함
	  * </pre>
	  */
	public PortPairExceptionDBDAORemoveEdi323AdjustmentDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAORemoveEdi323AdjustmentDSQL").append("\n"); 
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
		query.append("UPDATE	SCE_323_ADJ" ).append("\n"); 
		query.append("SET		" ).append("\n"); 
		query.append("		DELT_FLG		=	'Y'				," ).append("\n"); 
		query.append("		UPD_USR_ID		=	@[upd_usr_id]		," ).append("\n"); 
		query.append("		UPD_DT			=	SYSDATE" ).append("\n"); 
		query.append("WHERE	ADJ_RGST_DT		=	@[adj_rgst_dt]" ).append("\n"); 
		query.append("AND		ADJ_SEQ			=	@[adj_seq]" ).append("\n"); 

	}
}