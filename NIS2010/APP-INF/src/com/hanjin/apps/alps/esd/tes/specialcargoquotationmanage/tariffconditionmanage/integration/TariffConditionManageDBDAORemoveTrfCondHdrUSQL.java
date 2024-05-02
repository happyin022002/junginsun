/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TariffConditionManageDBDAORemoveTrfCondHdrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffConditionManageDBDAORemoveTrfCondHdrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CONDITION 삭제 처리
	  * </pre>
	  */
	public TariffConditionManageDBDAORemoveTrfCondHdrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration").append("\n"); 
		query.append("FileName : TariffConditionManageDBDAORemoveTrfCondHdrUSQL").append("\n"); 
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
		query.append("UPDATE TES_TRF_COND C" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("C.DELT_FLG = 'Y'" ).append("\n"); 
		query.append(", C.DELT_DT = SYSDATE" ).append("\n"); 
		query.append(", C.UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(", C.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE C.COND_NO = @[cond_no]" ).append("\n"); 

	}
}