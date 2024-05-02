/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSelectPopupDBDAOSearchContainerSelectPopupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 조풍연
*@LastVersion : 1.0
* 2009.07.27 조풍연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.containerselectpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Poong Yeon Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSelectPopupDBDAOSearchContainerSelectPopupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ContainerSelectPopup의 데이타 모델에 해당되는 값을 불러온다
	  * </pre>
	  */
	public ContainerSelectPopupDBDAOSearchContainerSelectPopupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.containerselectpopup.integration").append("\n"); 
		query.append("FileName : ContainerSelectPopupDBDAOSearchContainerSelectPopupRSQL").append("\n"); 
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
		query.append("SELECT A.CNTR_NO EQ_NO" ).append("\n"); 
		query.append(",	A.CNTR_TPSZ_CD EQ_TPSZ_CD" ).append("\n"); 
		query.append(",	B.BKG_NO" ).append("\n"); 
		query.append(",	B.BKG_STS_CD" ).append("\n"); 
		query.append(",	DECODE( TRIM(C.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append(", NULL, DECODE(A.CNTR_TPSZ_CD, 'D5', 'D4', NULL	)" ).append("\n"); 
		query.append(", C.CNTR_TPSZ_CD ) SUB_EQ_TPSZ_CD" ).append("\n"); 
		query.append(",	DECODE(MAX(D.CNTR_SUB_FLG), 'Y', 'Y', '') CNTR_SUB_FLG" ).append("\n"); 
		query.append("FROM BKG_CONTAINER A" ).append("\n"); 
		query.append(",	BKG_BOOKING B" ).append("\n"); 
		query.append(",	BKG_QUANTITY C" ).append("\n"); 
		query.append(",	TRS_TRSP_SVC_ORD 	D" ).append("\n"); 
		query.append("WHERE B.BKG_NO     = A.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.BKG_NO       = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND A.BKG_NO       = D.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.CNTR_NO      = D.EQ_NO(+)" ).append("\n"); 
		query.append("AND 'N'            = D.DELT_FLG	(+)" ).append("\n"); 
		query.append("AND B.BKG_NO IN (" ).append("\n"); 
		query.append("#if (${arrBkgno}.size() > 0 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach($code IN ${arrBkgno})" ).append("\n"); 
		query.append("#if($velocityCount < $arrBkgno.size())" ).append("\n"); 
		query.append("'$code'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$code'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'0000000'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY A.CNTR_NO" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", B.BKG_NO" ).append("\n"); 
		query.append(", B.BKG_STS_CD" ).append("\n"); 
		query.append(", C.CNTR_TPSZ_CD" ).append("\n"); 

	}
}