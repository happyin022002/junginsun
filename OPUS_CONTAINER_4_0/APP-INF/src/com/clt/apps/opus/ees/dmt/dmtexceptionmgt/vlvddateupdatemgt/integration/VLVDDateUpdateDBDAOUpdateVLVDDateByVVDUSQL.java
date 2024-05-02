/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VLVDDateUpdateDBDAOUpdateVLVDDateByVVDUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VLVDDateUpdateDBDAOUpdateVLVDDateByVVDUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VL/VD DATE UPDATE 등록	
	  * UI_DMT_2012	
	  * VL/VD Date Update by VVD
	  * </pre>
	  */
	public VLVDDateUpdateDBDAOUpdateVLVDDateByVVDUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offccd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vldateb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xMvmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xPort",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("userid",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.integration").append("\n"); 
		query.append("FileName : VLVDDateUpdateDBDAOUpdateVLVDDateByVVDUSQL").append("\n"); 
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
		query.append("UPDATE DMT_VSL_DT_UPD SET" ).append("\n"); 
		query.append("	PRV_DT     = null" ).append("\n"); 
		query.append(",	FX_DT      = TO_DATE(@[vldateb],'yyyymmdd')" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[userid]" ).append("\n"); 
		query.append(",	UPD_DT     = SYSDATE" ).append("\n"); 
		query.append(",	UPD_OFC_CD = @[offccd]" ).append("\n"); 
		query.append("WHERE	" ).append("\n"); 
		query.append("    VSL_CD       = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND	SKD_VOY_NO   = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND	SKD_DIR_CD   = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND	LOC_CD       = @[xPort]" ).append("\n"); 
		query.append("AND	VL_VD_DIV_CD = @[xMvmt]" ).append("\n"); 

	}
}