/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfUtilDBDAOBkgContainerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.09.21 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOBkgContainerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public OpfUtilDBDAOBkgContainerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOBkgContainerVORSQL").append("\n"); 
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
		query.append("SELECT 	C.BKG_NO, C.CNTR_TPSZ_CD, C.PCK_TP_CD, C.PCK_QTY, C.ORG_YD_CD" ).append("\n"); 
		query.append("FROM 	BKG_VVD V," ).append("\n"); 
		query.append("BKG_CONTAINER C" ).append("\n"); 
		query.append("WHERE 	V.BKG_NO		= C.BKG_NO" ).append("\n"); 
		query.append("AND		SUBSTR(C.CNTR_NO, 1, 11) = SUBSTR(@[cntr_no], 1, 11)" ).append("\n"); 
		query.append("AND		V.VSL_CD     	= @[vsl_cd]" ).append("\n"); 
		query.append("AND		V.SKD_VOY_NO   	= @[voy_no]" ).append("\n"); 
		query.append("AND		V.SKD_DIR_CD   	= @[dir_cd]" ).append("\n"); 
		query.append("AND		V.POL_YD_CD   	= @[yd_cd]" ).append("\n"); 
		query.append("AND 	C.CNTR_DELT_FLG = 'N'" ).append("\n"); 

	}
}