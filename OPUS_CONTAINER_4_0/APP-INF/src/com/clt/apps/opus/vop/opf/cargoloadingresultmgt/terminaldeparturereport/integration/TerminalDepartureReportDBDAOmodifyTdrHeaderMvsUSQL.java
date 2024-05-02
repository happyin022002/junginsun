/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOmodifyTdrHeaderMvsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOmodifyTdrHeaderMvsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOmodifyTdrHeaderMvsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gross_tml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gross_gc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_tml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_gc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOmodifyTdrHeaderMvsUSQL").append("\n"); 
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
		query.append("UPDATE  TDR_HEADER A " ).append("\n"); 
		query.append("   SET  A.MVS     = (" ).append("\n"); 
		query.append("                     SELECT SUM (MOVES)" ).append("\n"); 
		query.append("                       FROM (SELECT NVL(SUM (S.QTY), 0) AS MOVES" ).append("\n"); 
		query.append("                               FROM TDR_SUMMARY  S," ).append("\n"); 
		query.append("                                    TDR_HEADER   H" ).append("\n"); 
		query.append("                              WHERE S.VSL_CD   = H.VSL_CD" ).append("\n"); 
		query.append("                                AND S.VOY_NO   = H.VOY_NO" ).append("\n"); 
		query.append("                                AND S.DIR_CD   = H.DIR_CD" ).append("\n"); 
		query.append("                                AND S.PORT_CD  = H.PORT_CD" ).append("\n"); 
		query.append("                                AND S.CALL_IND = H.CALL_IND" ).append("\n"); 
		query.append("                                AND S.VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("                                AND S.VOY_NO   = @[voy_no]" ).append("\n"); 
		query.append("                                AND S.DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("                                AND S.PORT_CD  = @[port_cd]" ).append("\n"); 
		query.append("                                AND S.CALL_IND = @[call_ind]" ).append("\n"); 
		query.append("                                AND S.STATUS IN ('DS', 'DT', 'LM', 'LI', 'LT') " ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT NVL(SUM (DECODE (D.STATUS, 'ST', DECODE (D.SHIFT_TYPE, 'Q', 2, 1))),0)" ).append("\n"); 
		query.append("                                  + NVL(SUM (DECODE (D.STATUS, 'MI', DECODE (SUBSTR (D.MISHANDLE_CHK, 1, 1),'O', 1,-1))),0)  AS MOVES" ).append("\n"); 
		query.append("                               FROM TDR_CNTR_DETAIL   D" ).append("\n"); 
		query.append("                              WHERE D.VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("                                AND D.VOY_NO   = @[voy_no]" ).append("\n"); 
		query.append("                                AND D.DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("                                AND D.PORT_CD  = @[port_cd]" ).append("\n"); 
		query.append("                                AND D.CALL_IND = @[call_ind]" ).append("\n"); 
		query.append("                                AND (   (D.STATUS = 'ST' AND LENGTH (TRIM (PRECELL)) > 0)" ).append("\n"); 
		query.append("                                     OR (D.STATUS = 'MI' AND D.MISHANDLE_CHK IN ('OD', 'OL', 'SD', 'SL'))" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                      )                     " ).append("\n"); 
		query.append(",       A.GROSS_TML = @[gross_tml]" ).append("\n"); 
		query.append(",       A.NET_TML   = @[net_tml]" ).append("\n"); 
		query.append(",       A.GROSS_GC  = @[gross_gc]" ).append("\n"); 
		query.append(",       A.NET_GC    = @[net_gc]" ).append("\n"); 
		query.append(",       A.UPDATE_TIME = SYSDATE" ).append("\n"); 
		query.append(",       A.UPDATE_USER = @[update_user]" ).append("\n"); 
		query.append(" WHERE  A.VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("   AND  A.VOY_NO  = @[voy_no]" ).append("\n"); 
		query.append("   AND  A.DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("   AND  A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND  A.CALL_IND= @[call_ind]" ).append("\n"); 

	}
}