/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgCstmsAdvScacVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.22 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgCstmsAdvScacVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgCstmsAdvScacVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scac_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scac_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("A.SCAC_CD" ).append("\n"); 
		query.append(",    A.SCAC_NM" ).append("\n"); 
		query.append(",    A.USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append(",    A.HBL_LEN" ).append("\n"); 
		query.append(",    A.DIFF_RMK" ).append("\n"); 
		query.append(",	 A.UPD_USR_ID AS USER_ID" ).append("\n"); 
		query.append(",    TO_CHAR(A.UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(",	 B.PORT_CD" ).append("\n"); 
		query.append(",    MAX(B.PORT_CD) AS PORT_CD_MAX" ).append("\n"); 
		query.append(",    COUNT(B.PORT_CD) AS PORT_CD_COUNT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_SCAC A" ).append("\n"); 
		query.append(",BKG_SCAC_CD B" ).append("\n"); 
		query.append("WHERE A.SCAC_CD = B.SCAC_CD(+)" ).append("\n"); 
		query.append("#if (${scac_cd} != '')" ).append("\n"); 
		query.append("AND   A.SCAC_CD LIKE '%' || @[scac_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scac_nm} != '')" ).append("\n"); 
		query.append("AND   NVL(A.SCAC_NM,' ') LIKE '%' || @[scac_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usa_cstms_file_cd} != '')" ).append("\n"); 
		query.append("AND   NVL(A.USA_CSTMS_FILE_CD,' ') LIKE @[usa_cstms_file_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.SCAC_CD" ).append("\n"); 
		query.append(",A.SCAC_NM" ).append("\n"); 
		query.append(",A.USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append(",A.HBL_LEN" ).append("\n"); 
		query.append(",A.DIFF_RMK" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append(",B.PORT_CD" ).append("\n"); 
		query.append("ORDER BY A.SCAC_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgCstmsAdvScacVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}