/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VLVDDateUpdateDBDAOInsertVLVDDateByVVDCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VLVDDateUpdateDBDAOInsertVLVDDateByVVDCSQL implements ISQLTemplate{

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
	public VLVDDateUpdateDBDAOInsertVLVDDateByVVDCSQL(){
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
		params.put("xMvmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vldaten",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vldateb",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.integration").append("\n"); 
		query.append("FileName : VLVDDateUpdateDBDAOInsertVLVDDateByVVDCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_VSL_DT_UPD" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",VL_VD_DIV_CD" ).append("\n"); 
		query.append(",PRV_DT" ).append("\n"); 
		query.append(",FX_DT" ).append("\n"); 
		query.append(",VSL_UPD_RMK" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_OFC_CD" ).append("\n"); 
		query.append(",CLPT_IND_SEQ" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append(",SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append(",SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append(",@[xPort]" ).append("\n"); 
		query.append(",@[xMvmt]" ).append("\n"); 
		query.append(",TO_DATE(@[vldaten] , 'YYYY-MM-DD')" ).append("\n"); 
		query.append(",TO_DATE(@[vldateb] , 'YYYYMMDD')" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",@[userid]" ).append("\n"); 
		query.append(",NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[offccd]),SYSDATE)" ).append("\n"); 
		query.append(",@[offccd]" ).append("\n"); 
		query.append(",@[userid]" ).append("\n"); 
		query.append(",NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[offccd]),SYSDATE)" ).append("\n"); 
		query.append(",@[offccd]" ).append("\n"); 
		query.append(",@[clpt_ind_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}