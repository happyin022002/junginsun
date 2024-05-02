/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetBookingNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.03.12 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetBookingNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VL시 Multi kg Error를 위한 Booking No List
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetBookingNoListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOgetBookingNoListRSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED INDEX_DESC(A XAK1BKG_CONTAINER) INDEX(B XPKBKG_BOOKING) */" ).append("\n"); 
		query.append("B.VSL_CD," ).append("\n"); 
		query.append("B.SKD_VOY_NO," ).append("\n"); 
		query.append("B.SKD_DIR_CD," ).append("\n"); 
		query.append("B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("B.BKG_NO," ).append("\n"); 
		query.append("'' SVR_ID," ).append("\n"); 
		query.append("B.DEL_CD," ).append("\n"); 
		query.append("B.POD_CD" ).append("\n"); 
		query.append("FROM BKG_CONTAINER A," ).append("\n"); 
		query.append("BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND A.CNMV_CYC_NO >= @[cyc_no]" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND NVL (B.BKG_STS_CD, ' ') <> 'X'" ).append("\n"); 
		query.append("AND NVL (B.BKG_STS_CD, ' ') <> 'S'" ).append("\n"); 

	}
}