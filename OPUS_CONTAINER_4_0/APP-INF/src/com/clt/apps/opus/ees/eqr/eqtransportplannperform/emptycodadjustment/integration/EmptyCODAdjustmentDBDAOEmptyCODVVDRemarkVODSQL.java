/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDRemarkVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.01.06 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOEmptyCODVVDRemarkVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Remark Delete
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOEmptyCODVVDRemarkVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDRemarkVODSQL").append("\n"); 
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
		query.append("DELETE FROM EQR_MTY_COD_RMK" ).append("\n"); 
		query.append("WHERE	VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND	SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND	SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND	COD_CFM_DIV_CD = 'S'" ).append("\n"); 

	}
}