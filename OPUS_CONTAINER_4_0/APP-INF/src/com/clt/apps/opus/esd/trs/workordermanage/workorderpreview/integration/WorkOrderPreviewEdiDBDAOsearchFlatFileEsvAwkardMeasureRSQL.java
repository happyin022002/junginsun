/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvAwkardMeasureRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewEdiDBDAOsearchFlatFileEsvAwkardMeasureRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND
	  * {AWKARD_MEASUREMENT
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileEsvAwkardMeasureRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvAwkardMeasureRSQL").append("\n"); 
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
		query.append("SELECT T1.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("	WITH A AS" ).append("\n"); 
		query.append("	 (SELECT LEVEL LEV" ).append("\n"); 
		query.append("			,DECODE(LEVEL, 1, 'OverLengthFront', 2, 'OverLengthBack', 3, 'OverWidthLeft', 4, 'OverWidthRight', 5, 'OverHeight', 6, 'OverWeight') COL" ).append("\n"); 
		query.append("		FROM DUAL" ).append("\n"); 
		query.append("	  CONNECT BY LEVEL < 7)" ).append("\n"); 
		query.append("	SELECT A.COL AS AK_TYPE" ).append("\n"); 
		query.append("		  ,DECODE(A.LEV, 1, UNIT_CD, 2, UNIT_CD, 3, UNIT_CD, 4, UNIT_CD, 5, UNIT_CD, 6, '') AS AK_UNIT" ).append("\n"); 
		query.append("		  ,DECODE(A.LEV, 1, OVR_FWRD_LEN, 2, OVR_BKWD_LEN, 3, OVR_LF_LEN, 4, OVR_RT_LEN, 5, OVR_HGT, 6, OVR_WGHT) AS AK_QTY" ).append("\n"); 
		query.append("	  FROM (SELECT ROUND(B.OVR_FWRD_LEN / 100, 3) OVR_FWRD_LEN" ).append("\n"); 
		query.append("				  ,ROUND(B.OVR_BKWD_LEN / 100, 3) OVR_BKWD_LEN" ).append("\n"); 
		query.append("				  ,ROUND(B.OVR_LF_LEN / 100, 3) OVR_LF_LEN" ).append("\n"); 
		query.append("				  ,ROUND(B.OVR_RT_LEN / 100, 3) OVR_RT_LEN" ).append("\n"); 
		query.append("				  ,ROUND(B.OVR_HGT / 100, 3) OVR_HGT" ).append("\n"); 
		query.append("				  ,'' OVR_WGHT" ).append("\n"); 
		query.append("				  ,'M' UNIT_CD" ).append("\n"); 
		query.append("			  FROM BKG_AWK_CGO B" ).append("\n"); 
		query.append("			 WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("			   AND B.AWK_CGO_SEQ = @[awk_cgo_seq])" ).append("\n"); 
		query.append("		  ,A" ).append("\n"); 
		query.append(" ) T1" ).append("\n"); 
		query.append(" RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("    ON 1 = 1" ).append("\n"); 

	}
}