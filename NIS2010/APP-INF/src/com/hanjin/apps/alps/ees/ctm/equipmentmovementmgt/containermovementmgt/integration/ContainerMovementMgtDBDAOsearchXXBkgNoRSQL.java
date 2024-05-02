/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOsearchXXBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.25
*@LastModifier : 강환
*@LastVersion : 1.0
* 2013.09.25 강환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwan, Kang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOsearchXXBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LSO, SBO, TLL시 "XX" Movement의 이전 Movement가 IC나 ID면 해당 BKG No.가 XX Movement에 입력되록 조회한다.
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOsearchXXBkgNoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOsearchXXBkgNoRSQL").append("\n"); 
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
		query.append("SELECT  BKG_NO" ).append("\n"); 
		query.append("  FROM  CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND (CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO) IN (" ).append("\n"); 
		query.append("											SELECT /*+ INDEX_DESC(CTM_MOVEMENT XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("												    CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO" ).append("\n"); 
		query.append("											  FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("											 WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("											   AND ROWNUM  = 1" ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("AND MVMT_STS_CD IN ('IC', 'ID')" ).append("\n"); 

	}
}