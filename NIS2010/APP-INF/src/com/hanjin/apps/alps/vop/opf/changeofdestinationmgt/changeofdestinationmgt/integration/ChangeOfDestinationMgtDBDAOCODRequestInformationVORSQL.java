/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOCODRequestInformationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.06
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2010.09.06 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOCODRequestInformationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOCODRequestInformationVORSQL(){
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
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOCODRequestInformationVORSQL").append("\n"); 
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
		query.append("SELECT BCC.CNTR_NO," ).append("\n"); 
		query.append("BC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("BC.CNTR_WGT||' '||BC.WGT_UT_CD AS CNTR_WGT," ).append("\n"); 
		query.append("DECODE(BC.DCGO_FLG,'Y','DG',DECODE(BC.RC_FLG,'Y','RF',DECODE(BC.BB_CGO_FLG,'Y','BB',DECODE(BC.AWK_CGO_FLG,'Y','AK')))) AS CONDITION," ).append("\n"); 
		query.append("BCC.CNTR_STWG_NO," ).append("\n"); 
		query.append("M.CNTR_TPSZ_DESC," ).append("\n"); 
		query.append("'' AS PIC_EML," ).append("\n"); 
		query.append("'' AS CARRIER_CD," ).append("\n"); 
		query.append("'' AS NEW_POD_CD," ).append("\n"); 
		query.append("'' AS NEW_POD_FULL_NM," ).append("\n"); 
		query.append("'' AS OLD_POD_CD," ).append("\n"); 
		query.append("'' AS OLD_POD_FULL_NM" ).append("\n"); 
		query.append("FROM   BKG_COD_CNTR BCC" ).append("\n"); 
		query.append(",      BKG_CONTAINER BC" ).append("\n"); 
		query.append(",	   MDM_CNTR_TP_SZ M" ).append("\n"); 
		query.append("WHERE  BCC.BKG_NO  = BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BCC.CNTR_NO = BC.CNTR_NO(+)" ).append("\n"); 
		query.append("AND	   M.CNTR_TPSZ_CD = BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND    BCC.COD_SLCT_FLG = 'Y'" ).append("\n"); 
		query.append("AND    BCC.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND    BCC.COD_RQST_SEQ(+) = @[cod_rqst_seq]" ).append("\n"); 

	}
}