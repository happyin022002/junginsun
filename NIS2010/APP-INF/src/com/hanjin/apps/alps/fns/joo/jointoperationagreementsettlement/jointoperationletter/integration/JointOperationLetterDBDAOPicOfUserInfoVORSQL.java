/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationLetterDBDAOPicOfUserInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.12.02 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationLetterDBDAOPicOfUserInfoVORSQL implements ISQLTemplate{

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
	  * 2010.12.02 이준범 [CHM-201007349-01]
	  *  1. 보완 기능 
	  *    - JO Member Information Creation
	  *    - Inquiry of JO Member Information
	  *  2. 보완 요청 사항
	  *    - 컬럼 추가 : PIC of HJS(ID),  Name of PIC,  RHQ, Office, Start Date,  Creation Date
	  * </pre>
	  */
	public JointOperationLetterDBDAOPicOfUserInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_cntc_pic_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOPicOfUserInfoVORSQL").append("\n"); 
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
		query.append("SELECT A.USR_NM" ).append("\n"); 
		query.append("      ,A.OFC_CD" ).append("\n"); 
		query.append("      ,B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("  FROM COM_USER A" ).append("\n"); 
		query.append("      ,MDM_ORGANIZATION B" ).append("\n"); 
		query.append(" WHERE A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("   AND A.USR_ID = @[jo_cntc_pic_id]" ).append("\n"); 

	}
}