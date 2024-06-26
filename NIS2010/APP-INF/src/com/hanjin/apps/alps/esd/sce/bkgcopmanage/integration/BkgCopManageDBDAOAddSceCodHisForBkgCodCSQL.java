/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgCopManageDBDAOAddSceCodHisForBkgCodCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOAddSceCodHisForBkgCodCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking COD 발생 시 SCE COD History 데이터 생성
	  * </pre>
	  */
	public BkgCopManageDBDAOAddSceCodHisForBkgCodCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_del_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_del_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOAddSceCodHisForBkgCodCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_COD_HIS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	COD_RCV_SEQ," ).append("\n"); 
		query.append("	BKG_NO," ).append("\n"); 
		query.append("	OLD_POD_YD_CD," ).append("\n"); 
		query.append("	OLD_DEL_YD_CD," ).append("\n"); 
		query.append("	NEW_POD_YD_CD," ).append("\n"); 
		query.append("	NEW_DEL_YD_CD," ).append("\n"); 
		query.append("	COD_MAPG_STS_CD," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	SCE_COD_HIS_SEQ1.NEXTVAL AS COP_RCV_SEQ," ).append("\n"); 
		query.append("	@[bkg_no]," ).append("\n"); 
		query.append("	@[old_pod_yd_cd]," ).append("\n"); 
		query.append("	@[old_del_yd_cd]," ).append("\n"); 
		query.append("	@[new_pod_yd_cd]," ).append("\n"); 
		query.append("	@[new_del_yd_cd]," ).append("\n"); 
		query.append("	'00'," ).append("\n"); 
		query.append("	'COD_SYS'," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	'COD_SYS'," ).append("\n"); 
		query.append("	SYSDATE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}