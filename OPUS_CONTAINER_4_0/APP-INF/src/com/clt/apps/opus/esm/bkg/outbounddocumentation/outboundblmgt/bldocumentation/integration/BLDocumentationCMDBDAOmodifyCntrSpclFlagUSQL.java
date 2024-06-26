/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationCMDBDAOmodifyCntrSpclFlagUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.02 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOmodifyCntrSpclFlagUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * split 후 cntr별 special cargo flag를 재 계산한다.
	  * </pre>
	  */
	public BLDocumentationCMDBDAOmodifyCntrSpclFlagUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOmodifyCntrSpclFlagUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("SET DCGO_FLG      = NVL((SELECT 'Y' FROM BKG_DG_CGO  DG WHERE DG.BKG_NO = CNTR.BKG_NO AND DG.CNTR_NO = CNTR.CNTR_NO AND ROWNUM = 1), 'N')" ).append("\n"); 
		query.append(", RC_FLG        = NVL((SELECT 'Y' FROM BKG_RF_CGO  RF WHERE RF.BKG_NO = CNTR.BKG_NO AND RF.CNTR_NO = CNTR.CNTR_NO AND ROWNUM = 1), 'N')" ).append("\n"); 
		query.append(", AWK_CGO_FLG   = NVL((SELECT 'Y' FROM BKG_AWK_CGO AK WHERE AK.BKG_NO = CNTR.BKG_NO AND AK.CNTR_NO = CNTR.CNTR_NO AND ROWNUM = 1), 'N')" ).append("\n"); 
		query.append(", UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}