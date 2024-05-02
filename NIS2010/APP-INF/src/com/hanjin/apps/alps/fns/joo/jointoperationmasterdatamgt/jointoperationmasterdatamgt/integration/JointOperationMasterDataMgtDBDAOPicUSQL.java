/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOPicUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.14
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.12.14 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOPicUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement Pic 담당자 저장
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOPicUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_pic_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_pic_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOPicUSQL").append("\n"); 
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
		query.append("MERGE INTO JOO_STL_PIC A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT   @[stl_pic_seq] AS STL_PIC_SEQ  " ).append("\n"); 
		query.append("            ,@[trd_cd] AS TRD_CD   " ).append("\n"); 
		query.append("            ,@[jo_crr_cd] AS CRR_CD   " ).append("\n"); 
		query.append("            ,@[rlane_cd] AS RLANE_CD   " ).append("\n"); 
		query.append("            ,@[re_divr_cd] AS RE_DIVR_CD   " ).append("\n"); 
		query.append("            ,@[jo_stl_itm_cd] AS JO_STL_ITM_CD   " ).append("\n"); 
		query.append("            ,@[ofc_cd] AS OFC_CD   " ).append("\n"); 
		query.append("            ,@[stl_pic_nm] AS STL_PIC_NM               " ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    A.STL_PIC_SEQ = B.STL_PIC_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET A.TRD_CD             = @[trd_cd]" ).append("\n"); 
		query.append("          ,A.CRR_CD             = @[jo_crr_cd]" ).append("\n"); 
		query.append("          ,A.RLANE_CD           = @[rlane_cd]" ).append("\n"); 
		query.append("          ,A.RE_DIVR_CD         = @[re_divr_cd]" ).append("\n"); 
		query.append("          ,A.JO_STL_ITM_CD      = @[jo_stl_itm_cd]          " ).append("\n"); 
		query.append("          ,A.OFC_CD             = @[ofc_cd]          " ).append("\n"); 
		query.append("          ,A.STL_PIC_NM         = @[stl_pic_nm]                    " ).append("\n"); 
		query.append("		  ,A.UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("          ,A.UPD_USR_ID         = @[usr_id]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     STL_PIC_SEQ " ).append("\n"); 
		query.append("    ,TRD_CD " ).append("\n"); 
		query.append("    ,CRR_CD " ).append("\n"); 
		query.append("    ,RLANE_CD " ).append("\n"); 
		query.append("    ,RE_DIVR_CD " ).append("\n"); 
		query.append("    ,JO_STL_ITM_CD " ).append("\n"); 
		query.append("    ,OFC_CD " ).append("\n"); 
		query.append("    ,STL_PIC_NM " ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID    " ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("     (SELECT NVL(MAX(A.STL_PIC_SEQ)+1,'1') AS SEQ FROM JOO_STL_PIC A)" ).append("\n"); 
		query.append("    ,@[trd_cd]" ).append("\n"); 
		query.append("    ,@[jo_crr_cd]" ).append("\n"); 
		query.append("    ,@[rlane_cd]" ).append("\n"); 
		query.append("    ,@[re_divr_cd]" ).append("\n"); 
		query.append("    ,@[jo_stl_itm_cd]" ).append("\n"); 
		query.append("    ,@[ofc_cd]" ).append("\n"); 
		query.append("    ,@[stl_pic_nm]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}