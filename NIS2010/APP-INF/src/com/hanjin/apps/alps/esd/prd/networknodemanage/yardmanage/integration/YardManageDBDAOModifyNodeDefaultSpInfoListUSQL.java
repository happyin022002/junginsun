/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : YardManageDBDAOModifyNodeDefaultSpInfoListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class YardManageDBDAOModifyNodeDefaultSpInfoListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정
	  * </pre>
	  */
	public YardManageDBDAOModifyNodeDefaultSpInfoListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n6th_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("updusrid",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n6th_vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.integration").append("\n"); 
		query.append("FileName : YardManageDBDAOModifyNodeDefaultSpInfoListUSQL").append("\n"); 
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
		query.append("UPDATE MDM_YARD" ).append("\n"); 
		query.append("   SET " ).append("\n"); 
		query.append("		UPD_DT = SYSDATE," ).append("\n"); 
		query.append("#if(${chk_os_d} == 'D')" ).append("\n"); 
		query.append("			N4TH_VNDR_CNT_CD = @[n4th_vndr_cnt_cd]," ).append("\n"); 
		query.append("			N4TH_VNDR_SEQ    = TO_NUMBER(@[n4th_vndr_seq]),			" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${chk_os_e} == 'E')" ).append("\n"); 
		query.append("			N5TH_VNDR_CNT_CD = @[n5th_vndr_cnt_cd]," ).append("\n"); 
		query.append("			N5TH_VNDR_SEQ    = TO_NUMBER(@[n5th_vndr_seq]),		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${chk_os_f} == 'F')" ).append("\n"); 
		query.append("			N6TH_VNDR_CNT_CD = @[n6th_vndr_cnt_cd]," ).append("\n"); 
		query.append("			N6TH_VNDR_SEQ    = TO_NUMBER(@[n6th_vndr_seq]),	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		UPD_USR_ID       = @[updusrid]" ).append("\n"); 
		query.append(" WHERE YD_CD = @[yd_cd]" ).append("\n"); 

	}
}