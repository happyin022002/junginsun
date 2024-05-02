/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOCheckBkgNoVsSrNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.12.02 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOCheckBkgNoVsSrNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOCheckBkgNoVsSrNoVORSQL(){
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
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOCheckBkgNoVsSrNoVORSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append(",BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(",BK.POL_CD" ).append("\n"); 
		query.append(",BK.POD_CD" ).append("\n"); 
		query.append(",SR_NO" ).append("\n"); 
		query.append(",DECODE(BK.SPLIT_FLG, 'Y', 'S'," ).append("\n"); 
		query.append("DECODE(ISS.OBL_ISS_FLG, 'Y', 'B'," ).append("\n"); 
		query.append("DECODE(NVL(SR.SR_NO,'N'), 'N', 'N', 'A'))) AS CHK_VAL" ).append("\n"); 
		query.append("FROM   BKG_BOOKING      BK" ).append("\n"); 
		query.append(",BKG_SR_CRNT_RQST SR" ).append("\n"); 
		query.append(",BKG_BL_ISS       ISS" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    BK.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("AND    BK.BKG_NO = SR.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND    BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("AND    SR_NO(+) !=  @[sr_no]" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}