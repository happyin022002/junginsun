/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSelectPopupDBDAOSearchContainerSelectMainListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.10.21 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.containerselectpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSelectPopupDBDAOSearchContainerSelectMainListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O 내역조회
	  * </pre>
	  */
	public ContainerSelectPopupDBDAOSearchContainerSelectMainListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspSoSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspSoOfcCtyCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.containerselectpopup.integration").append("\n"); 
		query.append("FileName : ContainerSelectPopupDBDAOSearchContainerSelectMainListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",   TRO_SEQ  AS TRO_SEQ --1:BND,2:대륙코드,3,4:TRO SEQ" ).append("\n"); 
		query.append(",   TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",   TRSP_SO_SEQ" ).append("\n"); 
		query.append(",   TRSP_SO_OFC_CTY_CD||TRSP_SO_SEQ         AS TRSP_SO_OFC_CTY_CD_SEQ" ).append("\n"); 
		query.append(",   TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append(",   TRSP_WO_SEQ" ).append("\n"); 
		query.append(",   TRSP_WO_OFC_CTY_CD||TRSP_WO_SEQ         AS TRSP_WO_OFC_CTY_CD_SEQ" ).append("\n"); 
		query.append(",   EQ_TPSZ_CD" ).append("\n"); 
		query.append(",   ORG_BKG_NO" ).append("\n"); 
		query.append(",   '' AS RVIS_TRO_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD  = @[trspSoOfcCtyCd]" ).append("\n"); 
		query.append("AND TRSP_SO_SEQ         = @[trspSoSeq]" ).append("\n"); 

	}
}