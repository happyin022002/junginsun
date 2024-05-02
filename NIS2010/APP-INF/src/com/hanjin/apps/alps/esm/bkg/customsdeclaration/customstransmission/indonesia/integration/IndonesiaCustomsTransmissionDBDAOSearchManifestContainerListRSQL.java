/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IndonesiaCustomsTransmissionDBDAOSearchManifestContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndonesiaCustomsTransmissionDBDAOSearchManifestContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Indonesia 세관에 Manifest 신고할 내용을 download 받을 File로 생성하기 위해
	  * Container 정보를 조회한다. -- UI_BKG-0310, UI_BKG-0311
	  * </pre>
	  */
	public IndonesiaCustomsTransmissionDBDAOSearchManifestContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.integration").append("\n"); 
		query.append("FileName : IndonesiaCustomsTransmissionDBDAOSearchManifestContainerListRSQL").append("\n"); 
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
		query.append("SELECT B.CNTR_NO," ).append("\n"); 
		query.append("       DECODE(SUBSTR(B.CNTR_TPSZ_CD,2,1), '2', '20'," ).append("\n"); 
		query.append("                              '4', '40'," ).append("\n"); 
		query.append("                              '5', '40'," ).append("\n"); 
		query.append("                              '7', '45'," ).append("\n"); 
		query.append("							  '  ') AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       DECODE(A.RCV_TERM_CD, 'S', 'L', 'F') AS RCV_TERM_CD," ).append("\n"); 
		query.append("		(  SELECT MIN(CNTR_SEAL_NO) CNTR_SEAL_NO" ).append("\n"); 
		query.append("		   FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("		   WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		   AND CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("		 ) CNTR_SEAL_NO" ).append("\n"); 
		query.append("  FROM NISADM.BKG_BOOKING A, BKG_CONTAINER B" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND B.BKG_NO = A.BKG_NO" ).append("\n"); 

	}
}