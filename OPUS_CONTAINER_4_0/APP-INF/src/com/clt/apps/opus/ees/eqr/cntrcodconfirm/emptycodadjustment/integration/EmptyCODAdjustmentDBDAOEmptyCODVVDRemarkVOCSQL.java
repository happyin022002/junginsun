/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDRemarkVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.01.06 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOEmptyCODVVDRemarkVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Remark Insert
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOEmptyCODVVDRemarkVOCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofccd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("creusrid",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDRemarkVOCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_MTY_COD_RMK" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND COD_CFM_DIV_CD = @[div]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("DIFF_RMK = @[remark]," ).append("\n"); 
		query.append("UPD_OFC_CD = @[ofccd]," ).append("\n"); 
		query.append("UPD_USR_ID = @[creusrid]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	COD_CFM_DIV_CD" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append(",	@[div]" ).append("\n"); 
		query.append(",	@[remark]" ).append("\n"); 
		query.append(",	@[ofccd]" ).append("\n"); 
		query.append(",	@[creusrid]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[ofccd]" ).append("\n"); 
		query.append(",	@[creusrid]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}