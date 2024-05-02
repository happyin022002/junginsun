/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ServiceDBDAOAddMvmtStsCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAOAddMvmtStsCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Movement Status Code를 생성하는 쿼리
	  * </pre>
	  */
	public ServiceDBDAOAddMvmtStsCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAOAddMvmtStsCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_MVMT_STS" ).append("\n"); 
		query.append("		   (MVMT_STS_CD" ).append("\n"); 
		query.append("		   ,MVMT_STS_NM" ).append("\n"); 
		query.append("           ,DEST_YD_FLG" ).append("\n"); 
		query.append("		#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("           ,IO_BND_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("           ,DELT_FLG" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT)" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("       @[mvmt_sts_cd]" ).append("\n"); 
		query.append("      ,@[mvmt_sts_nm]" ).append("\n"); 
		query.append("	#if (${dest_yd_flg} != '')" ).append("\n"); 
		query.append("      ,@[dest_yd_flg]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	  ,'N'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("      ,@[io_bnd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${delt_flg} != '')" ).append("\n"); 
		query.append("      ,@[delt_flg]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	  ,'N'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("      ,@[user_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[user_id]" ).append("\n"); 
		query.append("      ,SYSDATE)" ).append("\n"); 

	}
}