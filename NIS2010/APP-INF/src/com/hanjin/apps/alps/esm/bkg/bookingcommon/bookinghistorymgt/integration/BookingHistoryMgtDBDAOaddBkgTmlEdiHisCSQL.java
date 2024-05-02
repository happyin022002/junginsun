/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOaddBkgTmlEdiHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOaddBkgTmlEdiHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미주 terminal edi 전송시 별도 ack를 받기 위한 table을 insert한다.
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOaddBkgTmlEdiHisCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOaddBkgTmlEdiHisCSQL").append("\n"); 
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
		query.append("insert into BKG_TML_EDI_HIS" ).append("\n"); 
		query.append("    (BKG_NO" ).append("\n"); 
		query.append("    , HIS_SEQ" ).append("\n"); 
		query.append("    , TML_EDI_RQST_NO" ).append("\n"); 
		query.append("    , SND_USR_ID" ).append("\n"); 
		query.append("    , SND_DT" ).append("\n"); 
		query.append("    , TML_RSPN_STS_CD" ).append("\n"); 
		query.append("    , RSPN_DT" ).append("\n"); 
		query.append("    , YD_CD" ).append("\n"); 
		query.append("    , RCV_USR_ID" ).append("\n"); 
		query.append("    , ERR_MSG" ).append("\n"); 
		query.append("    , MODI_DT" ).append("\n"); 
		query.append("    , SLAN_CD" ).append("\n"); 
		query.append("    , VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , SKD_DIR_CD" ).append("\n"); 
		query.append("    , POL_CD" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT)" ).append("\n"); 
		query.append("(select bk.BKG_NO" ).append("\n"); 
		query.append("    , @[his_seq]" ).append("\n"); 
		query.append("    , @[tml_edi_rqst_no]" ).append("\n"); 
		query.append("    , @[usr_id]" ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("    , null" ).append("\n"); 
		query.append("    , null" ).append("\n"); 
		query.append("    , bk.pol_cd||substr(bk.pol_nod_Cd, 6, 2)" ).append("\n"); 
		query.append("    , null" ).append("\n"); 
		query.append("    , null" ).append("\n"); 
		query.append("    , null" ).append("\n"); 
		query.append("    , vvd.SLAN_CD" ).append("\n"); 
		query.append("    , vvd.VSL_CD" ).append("\n"); 
		query.append("    , vvd.SKD_VOY_NO" ).append("\n"); 
		query.append("    , vvd.SKD_DIR_CD" ).append("\n"); 
		query.append("    , bk.POL_CD" ).append("\n"); 
		query.append("    , @[usr_id]" ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("    , @[usr_id]" ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("   from bkg_booking bk" ).append("\n"); 
		query.append("        , bkg_vvd vvd" ).append("\n"); 
		query.append("		, mdm_location loc" ).append("\n"); 
		query.append("  where bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("    and bk.pol_cd = vvd.pol_cd" ).append("\n"); 
		query.append("    and vvd.vsl_pre_pst_cd in ('S', 'T')" ).append("\n"); 
		query.append("    and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("    and bk.pol_cd = loc.loc_cd" ).append("\n"); 
		query.append("	and loc.conti_cd = 'M')" ).append("\n"); 

	}
}