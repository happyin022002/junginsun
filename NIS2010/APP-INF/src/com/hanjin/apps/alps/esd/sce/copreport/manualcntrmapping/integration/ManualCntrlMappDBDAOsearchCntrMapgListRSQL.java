/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ManualCntrlMappDBDAOsearchCntrMapgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.23 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualCntrlMappDBDAOsearchCntrMapgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrMapgList
	  * </pre>
	  */
	public ManualCntrlMappDBDAOsearchCntrMapgListRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.integration").append("\n"); 
		query.append("FileName : ManualCntrlMappDBDAOsearchCntrMapgListRSQL").append("\n"); 
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
		query.append("SELECT /*+ index(hdr XAK4SCE_COP_HDR ) */																" ).append("\n"); 
		query.append("       distinct(hdr.bkg_no) bkg_no                                        " ).append("\n"); 
		query.append("    -- , cntr.BKG_NO_SPLIT BKG_NO_SPLIT                                      " ).append("\n"); 
		query.append("     , cntr.cntr_no cntr_no                                                " ).append("\n"); 
		query.append("     , cntr.cntr_tpsz_cd cntr_tpsz_cd                                           " ).append("\n"); 
		query.append("     , TO_CHAR(bkg.bkg_cre_dt,'YYYY/MM/DD HH24:MI:SS') bkg_cre_dt          " ).append("\n"); 
		query.append("     , '' AS nis_event_dt --TO_CHAR(cntr.NIS_EVNT_DT,'YYYY/MM/DD HH24:MI:SS') nis_evnt_dt       " ).append("\n"); 
		query.append("     , cntr.cntr_vol_qty cntr_vol_qty                                      " ).append("\n"); 
		query.append("     , cntr.rcv_term_cd cntr_rcv_term_cd                              " ).append("\n"); 
		query.append("     , cntr.de_term_cd cntr_de_term_cd                                " ).append("\n"); 
		query.append("     , 'A' dist                                                             " ).append("\n"); 
		query.append(" FROM bkg_booking bkg" ).append("\n"); 
		query.append("    , bkg_container cntr" ).append("\n"); 
		query.append("    , sce_cop_hdr hdr                 " ).append("\n"); 
		query.append("WHERE bkg.bkg_no=cntr.bkg_no                                           " ).append("\n"); 
		query.append("  --AND bkg.bkg_no_split=cntr.bkg_no_split                              " ).append("\n"); 
		query.append("  AND bkg.bkg_no=hdr.bkg_no                                            " ).append("\n"); 
		query.append(" -- AND bkg.bkg_no_split=hdr.bkg_no_split                               " ).append("\n"); 
		query.append("  AND hdr.cop_sts_cd IN ( 'C', 'T', 'F', 'X', 'O')                     " ).append("\n"); 
		query.append("  AND bkg.bkg_sts_cd not in ( 'X' , 'S' )                              " ).append("\n"); 
		query.append("  AND bkg.bkg_cgo_tp_cd <> 'P'  " ).append("\n"); 
		query.append(" #if (${bkg_no} != '')                                         " ).append("\n"); 
		query.append("  AND bkg.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${cntr_no} != '')" ).append("\n"); 
		query.append("  AND cntr.cntr_no = @[cntr_no]                                              " ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append("  --AND cntr.cntr_no = ''                                             				" ).append("\n"); 
		query.append("  AND NOT EXISTS ( SELECT /*+ index( hdr XAK4SCE_COP_HDR ) */               " ).append("\n"); 
		query.append("                          hdr.bkg_no bkg_no                                   " ).append("\n"); 
		query.append("                       -- , hdr.bkg_no_split bkg_no_split                      " ).append("\n"); 
		query.append("                        , hdr.cntr_no cntr_no                                 " ).append("\n"); 
		query.append("                        , hdr.cntr_tpsz_cd tpsz_cd                             " ).append("\n"); 
		query.append("                     FROM sce_cop_hdr hdr                                     " ).append("\n"); 
		query.append("                    WHERE hdr.cop_sts_cd IN ( 'C', 'T', 'F', 'X', 'O')   " ).append("\n"); 
		query.append("                      #if (${bkg_no} != '')  " ).append("\n"); 
		query.append("	                  AND bkg.bkg_no = @[bkg_no]                               " ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      AND hdr.bkg_no = cntr.bkg_no                           " ).append("\n"); 
		query.append("                     -- and hdr.bkg_no_split=cntr.bkg_no_split               " ).append("\n"); 
		query.append("                      AND hdr.cntr_no = cntr.cntr_no                         " ).append("\n"); 
		query.append("                      AND hdr.cntr_no <> 'SMCU0000000'                     " ).append("\n"); 
		query.append("                  )" ).append("\n"); 

	}
}