/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchLstATDForSendVDLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.15 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchLstATDForSendVDLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VDL 전송에 사용될 가장 마지막으로 접수된 ATD 를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchLstATDForSendVDLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchLstATDForSendVDLRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(ACT_DT, 'YYYYMMDDHH24MISS') AS ACT_DT" ).append("\n"); 
		query.append("FROM SCE_ACT_RCV_IF" ).append("\n"); 
		query.append("WHERE (ACT_RCV_DT," ).append("\n"); 
		query.append("ACT_RCV_NO) IN (" ).append("\n"); 
		query.append("SELECT SUBSTR(MAX(ACT_RCV_DT||ACT_RCV_NO), 1, 8) ACT_RCV_DT," ).append("\n"); 
		query.append("SUBSTR(MAX(ACT_RCV_DT||ACT_RCV_NO), 9) ACT_RCV_NO --최근 수신된 Actual" ).append("\n"); 
		query.append("FROM SCE_ACT_RCV_IF" ).append("\n"); 
		query.append("WHERE NOD_CD = SUBSTR(@[nod_cd], 1, LENGTH(NOD_CD))" ).append("\n"); 
		query.append("AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("AND ACT_STS_MAPG_CD = 'ATD'" ).append("\n"); 
		query.append("AND ACT_RCV_TP_CD = '2'" ).append("\n"); 
		query.append("GROUP BY ACT_DT, ACT_RCV_TP_CD )" ).append("\n"); 
		query.append("AND ACT_DT < sysdate - (5/24/60)" ).append("\n"); 
		query.append("AND ACT_UMCH_TP_CD not in ('00'," ).append("\n"); 
		query.append("'XX')" ).append("\n"); 

	}
}