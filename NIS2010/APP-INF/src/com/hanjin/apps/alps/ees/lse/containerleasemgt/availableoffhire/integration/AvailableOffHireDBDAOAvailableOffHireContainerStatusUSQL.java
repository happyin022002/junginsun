/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AvailableOffHireDBDAOAvailableOffHireContainerStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.11.04 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailableOffHireDBDAOAvailableOffHireContainerStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선정된 대상장비의 반납상태 정보를 갱신합니다.
	  * </pre>
	  */
	public AvailableOffHireDBDAOAvailableOffHireContainerStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("offh_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration ").append("\n"); 
		query.append("FileName : AvailableOffHireDBDAOAvailableOffHireContainerStatusUSQL").append("\n"); 
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
		query.append("UPDATE  LSE_AVAL_OFFH" ).append("\n"); 
		query.append("SET     OFFH_STS_CD  = @[offh_sts_cd]," ).append("\n"); 
		query.append("UPD_USR_ID   = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("WHERE   OFFH_DUE_DT >= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("AND     CNTR_NO      = @[cntr_no]" ).append("\n"); 
		query.append("AND     OFFH_STS_CD  = DECODE(@[offh_sts_cd],'L','C','C','L')" ).append("\n"); 

	}
}