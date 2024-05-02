/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JooFileUploadDBDAOFileUploadListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.15
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.11.15 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JooFileUploadDBDAOFileUploadListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.11.08 이준범 [CHM-201006731-01]
	  *  1. 대상 기능
	  *    - JO Member Information Creation(JOO_0066)
	  *    - Inquiry of JO Member Information(JOO_0067)
	  *  2. 보완 대상
	  *    - Revenue Lane 정보 반영 
	  *    - MS Office( Excel, Worl, Power Point등) 첨부
	  *    - Carrier Name등 컬럼 반영
	  *  3. 목 적
	  *    - 그동안 Excel로 관리되던  선사별 이력 관리를 시스템내에서 관리하도록 하며
	  *    - Pending 사항에 대한 등록을 통해 선사별  Pending 사항이 간과 , 누락되지 않도록 함   
	  * </pre>
	  */
	public JooFileUploadDBDAOFileUploadListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cntc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.integration").append("\n"); 
		query.append("FileName : JooFileUploadDBDAOFileUploadListDSQL").append("\n"); 
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
		query.append("DELETE FROM JOO_CNTC_MBR_ATCH_FILE" ).append("\n"); 
		query.append(" WHERE JO_CRR_CD    = @[jo_crr_cd]" ).append("\n"); 
		query.append("   AND CRR_CNTC_SEQ = @[crr_cntc_seq]" ).append("\n"); 
		query.append("   AND FILE_SAV_ID  = @[file_sav_id]" ).append("\n"); 

	}
}